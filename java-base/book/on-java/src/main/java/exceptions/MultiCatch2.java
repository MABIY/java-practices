package exceptions;

/**
 * @author lh
 */
public class MultiCatch2 {
    void x() throws Except1,Except2,Except3,Except4 { }
    void proces1(){}
    void proces2(){}
    void f() {
        try {
            x();
        } catch (Except1 | Except2 e) {
            proces1();
        } catch (Except3 | Except4 e) {
            proces2();
        }
    }
}
