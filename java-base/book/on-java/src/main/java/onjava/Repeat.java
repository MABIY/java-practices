package onjava;

import java.util.stream.IntStream;

/**
 * @author lh
 */
public class Repeat {
    public static void repeat(int n ,Runnable action) {
        IntStream.range(0,n).forEach(i -> action.run());
    }
}
