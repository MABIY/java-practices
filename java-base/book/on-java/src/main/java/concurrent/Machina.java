package concurrent;

import atunit.Nap;

/**
 * @author lh
 */
public class Machina {
    public enum State{
        START,ONE,TWO,THREE,END;
        State step() {
            if(equals(END)) {
                return END;
            }
            return values()[ordinal()+1];
        }
    }

    private State state = State.START;
    private final int id;

    public Machina(int id) {
        this.id = id;
    }

    public static Machina work(Machina m) {
        System.out.println(Thread.currentThread().getName());
        if(!m.state.equals(State.END)) {
            new Nap(0.1);
            m.state =m.state.step();
        }
        System.out.println(m);
        return m;
    }

    @Override
    public String toString() {
        return "Machina" + id + ": " + (state.equals(State.END)? "complete": state);
    }
}
