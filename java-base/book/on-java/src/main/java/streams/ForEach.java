package streams;

import static streams.RandInts.rands;

/**
 * @author lh
 */
public class ForEach {
    static final int SZ = 14;

    public static void main(String[] args) {
        rands().limit(SZ).forEach(n -> System.out.printf("%d ", n));
        System.out.println();
        rands().limit(SZ).parallel().forEach(n -> System.out.printf("%d ", n));
        System.out.println();
        rands().limit(SZ).parallel().forEachOrdered(n -> System.out.printf("%d ", n));
    }
}
