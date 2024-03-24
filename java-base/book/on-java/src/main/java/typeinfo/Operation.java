package typeinfo;

import java.util.function.Supplier;

/**
 * @author lh
 */
public class Operation {
    public final Supplier<String> description;
    public final Runnable command;


    public Operation(Supplier<String> description, Runnable command) {
        this.description = description;
        this.command = command;
    }
}
