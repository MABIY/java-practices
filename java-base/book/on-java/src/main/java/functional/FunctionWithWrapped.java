package functional;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * @author lh
 */
public class FunctionWithWrapped {
    public static void main(String[] args) {
        Function<Integer,Double> fid = i-> (double)i;
        IntToDoubleFunction fid2 = i -> i;
    }
}
