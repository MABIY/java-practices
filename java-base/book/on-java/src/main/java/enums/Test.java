package enums;

/**
 *
 * @author lh
 */
public class Test {
    public static <T> T[] unsafe(T... elements) {
        return elements; // unsafe! don't ever return a parameterized varargs array
    }

    public static <T> T[] broken(T seed) {
        T[] plant = unsafe(seed, seed, seed); // broken! This will be an Object[] no matter what T is
        return plant;
    }

    public static void plant() {
        String[] plants = broken("seed"); // ClassCastException
    }

    public static void main(String[] args) {
        plant();
    }
}
