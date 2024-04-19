package patterns;

/**
 * @author lh
 */
interface StateBase {
    void f();
    void g();
    void h();
    void changeImpl(StateBase newImp);
}

class State implements StateBase {
    private StateBase implementation;

    public State(StateBase implementation) {
        this.implementation = implementation;
    }

    @Override
    public void f() {
        implementation.f();
    }

    @Override
    public void g() {
        implementation.g();
    }

    @Override
    public void h() {
        implementation.h();
    }

    @Override
    public void changeImpl(StateBase newImp) {
        this.implementation = newImp;
    }
}

class Implementation1 implements StateBase {
    @Override
    public void f() {
        System.out.println("Implementation1.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation1.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation1.h()");
    }

    @Override
    public void changeImpl(StateBase newImp) {
        throw new UnsupportedOperationException("changeImpl");
    }
}

class Implementation2 implements StateBase {
    @Override
    public void f() {
        System.out.println("Implementation2.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation2.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation2.h()");
    }

    @Override
    public void changeImpl(StateBase newImp) {
        throw new UnsupportedOperationException("changeImpl");
    }
}
public class StateDemo {
    static void test(StateBase b) {
        b.f();
        b.g();
        b.h();
    }

    public static void main(String[] args) {
        StateBase b = new State(new Implementation1());
        test(b);
        b.changeImpl(new Implementation2());
        test(b);
    }
}
