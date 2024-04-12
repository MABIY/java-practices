package atunit;

import java.util.concurrent.TimeUnit;

/**
 * @author lh
 */
public class Nap {
    public Nap(double t) {
        try {
            TimeUnit.DAYS.sleep((long)(1000*t));
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Nap(double t,String msg) {
        this(t);
        System.out.println(msg);
    }
}
