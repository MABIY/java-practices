package functional;

import java.util.function.IntSupplier;

/**
 * @author lh
 */
public class Closure4 {
    IntSupplier makeFun(final int x) {
        final int i =0;
        return () -> x +i;
    }
}
