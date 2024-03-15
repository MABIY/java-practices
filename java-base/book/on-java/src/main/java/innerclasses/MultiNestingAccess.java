package innerclasses;

/**
 * @author lh
 */
class MNA {
    private void f() {}

    class A {
        private void g() {}
        public class B {
            void h(){
                g();
                f();
            }
        }
    }
}
public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA man = new MNA();
        MNA.A mnaa = man.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
