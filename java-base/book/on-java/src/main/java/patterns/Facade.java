package patterns;

/**
 * @author lh
 */
class A {A(int x){}}
class B {
    B(Long x){}}
class C {
    C(double x){}}
public class Facade {
    static A makeA(int x) {
        return new A(x);
    }
    static B makeB(Long x) {
        return new B(x);
    }
    static C makeC(double x) {
        return new C(x);
    }

    public static void main(String[] args) {
        // The client programmer gets the objects
        // by calling the static methods:
        A a = Facade.makeA(1);
        B b = Facade.makeB(1L);
        C c = Facade.makeC(1);
    }
}
