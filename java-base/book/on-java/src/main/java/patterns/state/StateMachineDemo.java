package patterns.state;

import atunit.Nap;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author lh
 */
interface State {
    void run();
}

abstract class StateMachine {
    protected State currentState;

    protected abstract boolean changeState();

    protected final void runAll() {
        while (changeState()) {
            currentState.run();
        }
    }
}

// A different subclass for each state:
class Wash implements State {
    @Override
    public void run() {
        System.out.println("Washing");
        new Nap(0.5);
    }
}

class Spin implements State {
    @Override
    public void run() {
        System.out.println("Spinning");
        new Nap(0.5);
    }
}

class Rinse implements State {
    @Override
    public void run() {
        System.out.println("Rinsing");
        new Nap(0.5);
    }
}

class Washer extends StateMachine {
    private int i = 0;
    private Iterator<State> states =
            Stream.of(new Wash(), new Spin(), new Rinse(), new Spin()).iterator();

    public Washer() {
        runAll();
    }

    @Override
    protected boolean changeState() {
        if(!states.hasNext()) {
            return false;
        }
        currentState = states.next();
        return true;
    }
}

public class StateMachineDemo {
    public static void main(String[] args) {
        new Washer();
    }
}
