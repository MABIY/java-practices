package interfaces.music4;

/**
 * @author lh
 */
class A {
     interface B {
         void f();

    }

    public class Bimp implements B {
        @Override
        public void f() {

        }
    }

    public static class Bimp2 implements B{
        @Override
        public void f() {

        }
    }

    public interface C {
         void f();
    }

    class CImp implements C {
        @Override
        public void f() {

        }
    }

    private class CImp2 implements  C{
        @Override
        public void f() {

        }
    }

    private interface  D {
         void f();
    }

    private class Dimp implements D{
        @Override
        public void f() {

        }
    }
    public class Dimp2 implements D{
        @Override
        public void f() {

        }
    }

    public Dimp2 getDimp2(){
         return new Dimp2();
    }

    public D getD() {
        System.out.println("getD");
         return new Dimp2();
    }

    private D dRef;

     public void receiveD(D d) {
         dRef =d;
         dRef.f();
        System.out.println("receiverD");
     }

}

interface E {
     interface G{
         void f();
    }

    public interface H {
         void f();
    }
    void g();
}
public class NestingInterfaces {
    public class Bimp implements A.B {
        @Override
        public void f() {

        }
    }

    class CImp implements A.C {
        @Override
        public void f() {

        }
    }

    class EImp implements E {
        @Override
        public void g() {

        }
    }

    class EGImp implements E.G{
        @Override
        public void f() {

        }
    }

    class EGImp2 implements E {
        @Override
        public void g() {

        }
        class EG implements E.G{
            @Override
            public void f() {

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A a2 =  new A();
        A.Dimp2 x= a2.getDimp2();
    }
}
