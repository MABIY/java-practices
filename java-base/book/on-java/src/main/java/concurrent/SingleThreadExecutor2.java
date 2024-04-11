package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author lh
 */
public class SingleThreadExecutor2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0,10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}
