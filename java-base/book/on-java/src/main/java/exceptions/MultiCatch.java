package exceptions;

/**
 * @author lh
 */
public class MultiCatch {
    void x() throws Except1,Except2,Except3,Except4 { }
    void proces(){}
    void f() {
        try {
            x();
        } catch (Except1 | Except2 | Except3 | Except4 e) {
            proces();
        }
    }
}
