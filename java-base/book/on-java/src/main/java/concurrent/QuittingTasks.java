package concurrent;

import atunit.Nap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author lh
 */
public class QuittingTasks {
    public static final int COUNT =150;

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        List<QuittableTask> tasks = IntStream.range(1,COUNT)
                .mapToObj(QuittableTask::new)
                .peek(es::execute)
                .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }
}
