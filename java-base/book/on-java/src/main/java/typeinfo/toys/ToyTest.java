package typeinfo.toys;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lh
 */
interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

class Toy {
    // 注释下面的无参构造起会引发 NoSuchMethodError
        Toy() { }

    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FacyToy");
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class<Toy> up = c.getSuperclass();
        Object obj = null;
        Class b = Boolean.TYPE;
        Class a = boolean.class;


        try {
            // Requires no-arg constructor:
            obj = up.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            System.out.println("InvocationTargetException");
            System.exit(1);
        } catch (InstantiationException e) {
            System.out.println("InstantiationException");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
            System.exit(1);
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
