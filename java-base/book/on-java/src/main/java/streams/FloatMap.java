package streams;

import java.util.stream.Stream;

/**
 * @author lh
 */
public class FloatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Kermit", "Beaker")).forEach(System.out::println);
    }
}
