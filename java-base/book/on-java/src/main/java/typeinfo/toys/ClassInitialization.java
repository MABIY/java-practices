package typeinfo.toys;

import java.util.Random;

/**
 * @author lh
 */
class Initable {
    static final int STATIC_FINAL =47;
    static final int STATIC_FINAL2= ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal =147;
    static {
        System.out.println("Initalizing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random rand =  new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        System.out.println(Initable.STATIC_FINAL);
        // Does trigger initialization:
        System.out.println(Initable.STATIC_FINAL2);
        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("typeinfo.toys.Initable3");
        System.out.println("After creating Initable2 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
