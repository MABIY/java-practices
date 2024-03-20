package exceptions;

/**
 * @author lh
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Except1();
        } catch (Except1 e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {f();}
    static void h() {g();}

    public static void main(String[] args) {
        f();
        System.out.println("*******");
        g();
        System.out.println("*******");
        h();
    }
}
