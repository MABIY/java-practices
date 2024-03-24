package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author lh
 */
public class ShowMethods {

    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public ShowMethods() {
    }
    public ShowMethods(String a) {
    }


    public static void main(String[] args) {
        ShowMethods a = new ShowMethods();
        args= new String[] {"typeinfo.ShowMethods","ShowMethods"};
        if(args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] mehtods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if(args.length==1) {
                for (Method mehtod : mehtods) {
                    System.out.println(
                            p.matcher(mehtod.toString()).replaceAll("")
                    );
                }

                for (Constructor ctor : ctors) {
                    System.out.println(
                            p.matcher(ctor.toString()).replaceAll("")
                    );
                }
            }else {
                for (Method mehtod : mehtods) {
                    System.out.println(p.matcher(mehtod.toString()).replaceAll(""));
                    lines++;
                }

                for (Constructor ctor : ctors) {
                    if(ctor.toString().contains(args[1])) {
                        System.out.println(
                                p.matcher(ctor.toString()).replaceAll("")
                        );
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
