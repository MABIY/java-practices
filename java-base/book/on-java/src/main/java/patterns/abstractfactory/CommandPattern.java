package patterns.abstractfactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 */
public class CommandPattern {
    public static void main(String[] args) {
        List<Runnable> macro = Arrays.asList(
                ()-> System.out.print("Hello "),
                ()-> System.out.print("World! "),
                ()-> System.out.print("I'm the command pattern!")
        );
        macro.forEach(Runnable::run);
    }
}
