package concurrent;

import atunit.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author lh
 */
public class SingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0,10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);
        System.out.println("All tasks submitted");
        exec.shutdown();
        while (!exec.isTerminated()) {
            System.out.println(Thread.currentThread().getName() +
                    " awaiting termination");
            new Nap(0.1);
        }
    }
}
