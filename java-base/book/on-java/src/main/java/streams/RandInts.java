package streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author lh
 */
public class RandInts {
    private static int[] rints = new Random(47).ints(0,1000).limit(1000).toArray();
    public static IntStream rands() {
        return Arrays.stream(rints);
    }
}
