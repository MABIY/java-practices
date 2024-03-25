package generics;

/**
 * @author lh
 */
abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc  = new XCreator();
        xc.f();
    }
}

class X {}

class XCreator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
