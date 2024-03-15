package interfaces.music4;

/**
 * @author lh
 */
interface T1{
    void f();
}
interface T2{
    int f(int i);
}

interface T3 {
    int f();
}

class C {
    public int f(){
        return 1;
    }
}

class C2 implements T1, T2 {
    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 0;
    }
}

class C3 extends C implements T2 {


    @Override
    public int f(int i) {
        return 0;
    }
}

class C4 extends C implements T3 {

}


public class InterfaceCollision {
}
