package functional;

/**
 * @author lh
 */
interface Callable{
    void call(String s);
}

class Describe{
    void show(String msg){
        System.out.println(msg);
    }
}
public class MethodReferences {
    static void hello(String name) {
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        public Description(String about) {
            this.about = about;
        }

        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg){
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c =d::show;
        c.call("call()");

        c = MethodReferences::hello;
        c.call("Bob");


        c = new Description("valuable")::help;
        c.call("infromation");

        c =Helper::assist;
        c.call("Help!");
    }
}
