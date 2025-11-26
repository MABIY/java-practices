package object;

/**
 * @author lh
 */
public class StaticTest {
    static int i = 47;

    public static void main(String[] args) {
        // <editor-fold desc="test static and ++ operator">
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        st1.i++;
        System.out.println("st1.i:" + st1.i);
        System.out.println("st2i:" + st2.i);
        // </editor-fold>

        // <editor-fold desc="objec invoke static method or Class invoke static method">
        Incrementable sf = new Incrementable();
        sf.increment();
        Incrementable.increment();
        System.out.println("StaticTest.i result:" + StaticTest.i);
        // </editor-fold>
    }
}

class Incrementable {
    static void increment() {
        StaticTest.i++;
    }
}
