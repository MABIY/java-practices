package streams;

import java.util.stream.Stream;

/**
 * @author lh
 */
public class Bubbles {
    public static void main(String[] args) {
        Stream.generate(Bubble::bubbler).limit(5).forEach(System.out::println);
    }
}
