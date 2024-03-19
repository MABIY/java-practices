package streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class OptionalFlatMap {
    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, Optional<String>> func) {
        System.out.println(" ---( " + descr + " )---");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(testStream().skip(i).findFirst().flatMap(func));
        }
    }

    public static void main(String[] args) {
        test("Add brackets", s -> Optional.of("[" + s + "]"));
        test("INcremetn", s -> {
            try {
                return Optional.of(Integer.parseInt(s) + 1 + "");
            } catch (NumberFormatException e) {
                return Optional.of(s);
            }
        });

        test("Replace", s -> Optional.of(s.replace("2", "9")));
        test("Take last digit", s -> Optional.of(!s.isEmpty() ? s.charAt(s.length() - 1) + "" : s));
    }
}
