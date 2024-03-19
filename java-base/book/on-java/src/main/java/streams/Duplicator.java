package streams;

import java.util.stream.Stream;

/**
 * @author lh
 */
public class Duplicator {
    public static void main(String[] args) {
        Stream.generate(() -> "duplicate").limit(3).forEach(System.out::println);
    }
}
