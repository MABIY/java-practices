package functional;

import java.util.function.IntSupplier;

/**
 * @author lh
 */
public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i =0;
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x+i;
            }
        };
    }
}
