package housekeeping;

/**
 * @author lh
 */
public class MethodInit3 {
//    int j = g(i); // Illegal forward reference

    int i =f();

    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }

    public static void main(String[] args) {

    }
}
