package concurrent;

import java.util.concurrent.Callable;

/**
 * @author lh
 */
public class CountingTask implements Callable<Integer> {
    final int id;

    @Override
    public Integer call() {
        Integer val = 0;
        for (int i = 0; i <100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName() +" " + val);
        return val;
    }

    public CountingTask(int id) {
        this.id = id;
    }
}
