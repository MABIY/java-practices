package functional;

import java.util.function.IntSupplier;

/**
 * @author lh
 */
public class Closure6 {
    IntSupplier makeFun(int x) {
        int i =0;
        i++;
        x++;
        int iFinal =i;
        int xFinal = x;
        return () -> xFinal + iFinal;
    }
}
