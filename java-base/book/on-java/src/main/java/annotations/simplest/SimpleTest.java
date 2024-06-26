package annotations.simplest;

/**
 * @author lh
 */
@Simple
public class SimpleTest {
    @Simple
    int i;

    @Simple
    public SimpleTest() {}

    @Simple
    public void foo() {
        System.out.println("SimpleTest.foo()");
    }

    @Simple
    public void bar(String s, int i, float f) {
        System.out.println("SimpleTest.bar()");
    }

    @Simple
    public static void main(String[] args) {
        @Simple SimpleTest st = new SimpleTest();
        st.foo();
    }
}
