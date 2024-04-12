package concurrent;

import javax.imageio.stream.ImageInputStream;
import java.util.concurrent.CompletableFuture;

/**
 * @author lh
 */
public class CatchCompletableExceptions {
    static void handleException(int failcount) {
        // Call the function only if there's an
        // exception, must produce some  type as come in
        CompletableExceptions.test("exceptionally", failcount)
                .exceptionally(
                        (ex) -> { // Function
                            if (ex == null) System.out.println("I don't get id yet");
                            return new Breakable(ex.getMessage(), 0);
                        })
                .thenAccept(str -> System.out.println("result: " + str));

        // Create a new result (recover):
        CompletableExceptions.test("handle", failcount)
                .handle((result, fail) -> {
                    if (fail != null) return "Failure recovery object";
                    else return result + " is good";
                })
                .thenAccept(str -> System.out.println("result: " + str));

        // Do something but pass the same result through:
        CompletableExceptions.test("whenComplete", failcount)
                .whenComplete(((result, fail) -> {
                    if (fail != null) System.out.println("It failed");
                    else System.out.println(result + " OK");
                }))
                .thenAccept(r -> System.out.println("result: " + r));
    }

    public static void main(String[] args) {
        System.out.println("**** Failure Mode ****");
        handleException(2);
        System.out.println("**** Success Mode ****");
        handleException(0);
    }
}
