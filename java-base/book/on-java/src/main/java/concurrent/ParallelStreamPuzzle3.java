package concurrent;

import onjava.ConvertTo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author lh
 */
public class ParallelStreamPuzzle3 {
    public static void main(String[] args) {
        List<Integer> x = null;
        do {

            x = IntStream.range(0, 30)
                    .peek(e -> System.out.println(e + ": " + Thread.currentThread().getName()))
                    .limit(10)
                    .parallel()
                    .boxed()
                    .collect(Collectors.toList());
            System.out.println(x);
        } while (Arrays.equals(ConvertTo.primitive(x.toArray(new Integer[10])), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
