package functional;

import java.util.function.Function;

/**
 * @author lh
 */
interface FuncSS extends Function<String,String> {}
public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
