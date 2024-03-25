package generics;

import java.util.stream.Stream;

/**
 * @author lh
 */
public class BasicSupplierDemo {
    public static void main(String[] args) {
        Stream.generate(BasicSupplier.create(CountedObject.class)).limit(5).forEach(System.out::println);
    }
}
