package validating;

import java.util.Arrays;

/**
 * @author lh
 */
public class CircularQueue {
    private Object[] data;
    private int in =0,// Next available storage space
            out=0;  // next gettable object
                    // Has it wrapped around the circular queue?
    private boolean wrapped =false;

    public boolean isWrapped() {
        return wrapped;
    }

    public CircularQueue(int size) {
        data = new Object[size];
        assert invariant();
    }

    public boolean empty() {
        return !wrapped && in == out;
    }

    public boolean full() {
        return wrapped && in ==out;
    }

    public void put(Object item) {
        precondition(item !=null, "put() null item");
        precondition(!full(),"put() into full CircularQueue");
        assert invariant();
        data[in++] = item;

        if(in >= data.length) {
            in = 0;
            wrapped = true;
        }

        assert invariant();
    }

    public Object get() {
        precondition(!empty(),"get() from empty CircularQueue");
        assert  invariant();
        Object returnVal = data[out];
        data[out] =null;
        out++;
        if(out >= data.length) {
            out=0;
            wrapped =false;
        }
        assert postcondition(returnVal !=null,"null item in CiruclarQueue");
        assert invariant();
        return returnVal;
    }

    private static void precondition(boolean cond, String msg) {
        if(!cond) throw new CircularQueueException(msg);
    }

    private static boolean postcondition(boolean cond, String msg) {
        if(!cond) throw new CircularQueueException(msg);
        return true;
    }
    private boolean invariant() {
        for(int i = out; i !=in; i = (i+1)% data.length) {
            if(data[i] == null) {
                throw new CircularQueueException("null is DCircularQueue");
            }
        }
        if(full()) return  true;

        for(int i = in; i !=out ; i = (i + 1)% data.length) {
            if(data[i] != null) {
                throw new CircularQueueException("null is DCircularQueue");
            }
        }
        return true;
    }

    public String dump() {
        return "in = " + in +
                ", out = " + out +
                ", full()  = " + full() +
                ", empty() = " + empty() +
                ", CircularQueue =" + Arrays.asList(data);
    }

}
