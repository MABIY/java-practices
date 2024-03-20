package exceptions;

import java.io.File;

/**
 * @author lh
 */
class Reporter implements AutoCloseable {
    String name = getClass().getSimpleName();

    public Reporter() {
        System.out.println("Creating " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing" + name);
    }
}

class First extends Reporter {}

class Second extends Reporter {
    @Override
    public void close() {

    }
}

public class AutoCloseableDetails {
    public static void main(String[] args) {
        try (First f = new First();
                Second s = new Second()) {}
    }
}
