package concurrent;

import atunit.Nap;

/**
 * @author lh
 */
public class NapTask implements Runnable{
    final int id;

    public NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new Nap(0.1); // Seconds
        System.out.println(this +" " + Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "NapTask[" + id+"]";
    }
}
