package functional;

import java.util.function.Function;

/**
 * @author lh
 */
public class CurryingAndPartials {
    // 未柯里化
    static String  uncurried(String a ,String b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 柯里化的函数
        Function<String, Function<String,String>> sum
                = a-> b-> a + b;
        System.out.println(uncurried("Hi ","Ho"));
        Function<String,String> hi = sum.apply("Hi ");
        System.out.println(hi.apply("Ho"));

        // 部分应用:
        Function<String,String> sumHI = sum.apply("Hup ");
        System.out.println(sumHI.apply("Ho"));
        System.out.println(sumHI.apply("Hey"));

    }
}
