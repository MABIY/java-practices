package streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class FunctionMap {
    static String[] elements = {"12","","23","45"};
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String,String> func) {
         System.out.println(" ---( " + descr + " )---");
        testStream().map(func).forEach(System.out::println);
    }

    public static void main(String[] args) {
        test("add brackets",s -> "[" + s + "]");
        test("Incremetn", s -> {
            try {
                return Integer.parseInt(s) +1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });
        test("Replace ", s-> s.replace("2","9"));
        test("Take last digit", s-> !s.isEmpty() ? s.charAt(s.length()-1) +"":s);
    }
}
