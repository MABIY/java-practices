package onjava;

import java.util.Random;

/**
 * @author lh
 */
public class Enums {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T rand(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
