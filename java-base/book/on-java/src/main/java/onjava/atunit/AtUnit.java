package onjava.atunit;

import annotations.AtUnitExample1;
import onjava.ProcessFiles;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 */
public class AtUnit implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests = new ArrayList<>();
    static long testsRun = 0;
    static long failures = 0;


    @Override
    public void process(File cfile) {
        try {
            String cName = ClassNameFinder.thisClass(Files.readAllBytes(cfile.toPath()));
            if(!cName.startsWith("public:"))
                return;
            cName = cName.split(":")[1];
            if(!cName.contains("."))
                return;// Ignore unpackaged classes
            testClass = Class.forName(cName);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        TestMethods testMethods = new TestMethods();
        Method creator = null;
        Method cleanup = null;
        for (Method m : testClass.getDeclaredMethods()) {
           testMethods.addIfTestMethod(m);
           if(creator == null) {
               creator = checkForCreatorMethod(m);
           }
           if(cleanup == null) {
               cleanup = checkForCreatorMethod(m);
           }
        }
        if(testMethods.size()> 0) {
           if(creator ==null)  {
               try {
                   if(!Modifier.isPublic(testClass.getDeclaredConstructor().getModifiers())) {
                        System.out.println("Error: " + testClass + " zero-argument constructor must be public");
                        System.exit(1);
                   }
               } catch (NoSuchMethodException e) {
                   // Synthesized zero-argument constructor;ok
               }
           }
            System.out.println(testClass.getName());
        }
        for (Method m : testMethods) {
            System.out.print("   . " + m.getName() +" ");
            try{
                Object testObject = createTestObject(creator);
                boolean success = false;

                try {
                    if(m.getReturnType().equals(boolean.class)){
                        success = (Boolean)m.invoke(testObject);
                    } else {
                        m.invoke(testObject);
                        success = true; // If no assert fails
                    }
                } catch (InvocationTargetException e) {
                    // Actual exception is inside e:
                    System.out.println(e.getCause());
                }
                System.out.println(success ? "" : "(failed)");
                testsRun++;
                if(!success) {
                    failures++;
                    failedTests.add(testClass.getName() +": " + m.getName());
                }
                if (cleanup != null) {
                    cleanup.invoke(testObject,testObject);
                }
            }catch (IllegalAccessException | IllegalArgumentException|InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class TestMethods extends ArrayList<Method> {
        void addIfTestMethod(Method m) {
            if(m.getAnnotation(Test.class) == null) {
                return;
            }
            if(!(m.getReturnType().equals(boolean.class) ||
                    m.getReturnType().equals(void.class))
            ) {
                throw new RuntimeException("@Test method" + " must return boolean or void");
            }
            m.setAccessible(true); // If it's private, etc:
            add(m);
        }
    }

    private static Method checkForCreatorMethod(Method m) {
        if(m.getAnnotation(TestObjectCreate.class) == null)
           return null;
        if(!m.getReturnType().equals(testClass))
            throw new RuntimeException("@TestObjectCreate "
            +"must return instance of Class to be tested");
        if((m.getModifiers() & Modifier.STATIC) < 1)
            throw new RuntimeException("@TestObjectCreate " + "must be static.");
        m.setAccessible(true);
        return m;
    }

    private static Object createTestObject(Method creator){
        if(creator !=null) {
            try {
                return creator.invoke(testClass);
            } catch (IllegalAccessException |IllegalArgumentException| InvocationTargetException e) {
                throw new RuntimeException("Couldn't run " + "@TestObject  (creator) method.");
            }
        } else { // Use the zero-argument constructor:
            try {
                return testClass.getConstructor() .newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException("Couldn't create a test object. " +
                        "Try using a @TestObject method.");
            }
        }
    }

    public static void main(String[] args) {
        args =new String[] {"java-base/book/on-java/build/classes/java/main/annotations/AtUnitExample1.class"};
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true); // Enable assert
        new ProcessFiles(new AtUnit(),"class").start(args);
        if(failures == 0) {
            System.out.println("OK (" + testsRun +" tests)");
        } else {
            System.out.println("(" + testsRun + " tests)");
            System.out.println("\n>>> " + failures + " FAILURE" + (failures > 1 ? "S" : "" + " <<<"));
            for (String failed : failedTests) {
                System.out.println("  " + failed);
            }
        }
    }
}
