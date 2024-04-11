package concurrent;

import java.util.stream.IntStream;

/**
 * @author lh
 */
public class CountingStream {
    public static void main(String[] args) {
        System.out.println(IntStream.range(0, 10)
                .parallel()
                .mapToObj(CountingTask::new)
                .map(CountingTask::call)
                .reduce(0, Integer::sum));
    }
}
