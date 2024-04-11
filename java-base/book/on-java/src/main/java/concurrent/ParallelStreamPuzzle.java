package concurrent;

import onjava.ConvertTo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class ParallelStreamPuzzle {
    static class IntGenerator implements Supplier<Integer> {
        @Override
        public Integer get() {
            return current++;
        }

        private int current = 0;
    }

    public static void main(String[] args) {
        List<Integer> x =null;
        do{
             x = Stream.generate(new IntGenerator())
//                    .parallel()
                    .limit(10)
                    .collect(Collectors.toList());
            System.out.println(x);
        } while (Arrays.equals(ConvertTo.primitive(x.toArray(new Integer[10])),new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
