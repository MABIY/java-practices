package functional;

import java.util.function.IntSupplier;

/**
 * @author lh
 */
public class Closure2 {
    IntSupplier makeFun(int x) {
        int i= 0;
        return () -> x +i;
    }
}
