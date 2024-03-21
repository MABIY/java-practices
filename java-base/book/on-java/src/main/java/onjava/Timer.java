package onjava;

import java.sql.Time;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author lh
 */
public class Timer {
    private long start = System.nanoTime();

    public long duration(){
        return NANOSECONDS.toMillis(System.nanoTime() - start);
    }

    public static long duration(Runnable test) {
        Timer timer = new Timer();
        test.run();
        return timer.duration();
    }
}
