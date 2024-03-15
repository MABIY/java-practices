package innerclasses;

/**
 * @author lh
 */
abstract class Base {
    Base(Integer i) {
        System.out.println("Base constructor, i = " + i);
    }
    public abstract void f();
}
public class AnnoymousConstructor {
    public static Base getBase(Integer i) {
        return new Base(i) {
            {
                System.out.println("Inside instance intializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
