package streams;

import java.util.Optional;

/**
 * @author lh
 */
public class CreatingOptionals {
    static void test(String testName, Optional<String>opt) {
        System.out.println(" ==="+ testName +" === ");
        System.out.println(opt.orElse("Null"));
    }

    public static void main(String[] args) {test("empty",Optional.empty());
        test("of",Optional.of("Howdy"));
        try {
            test("of",Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }
        test("OfNullable",Optional.ofNullable("Hi"));
        test("OfNullable",Optional.ofNullable(null));
    }
}
