package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author lh
 */
public class CompletableExceptions {
    static CompletableFuture<Breakable> test(String id, int failcount) {
        return CompletableFuture.completedFuture(new Breakable(id, failcount))
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work);
    }

    public static void main(String[] args) {
        // Exceptions don't appear ...
        test("A",1);
        test("B",2);
        test("C",3);
        test("D",4);
        test("E",5);
        // ... until you try to fetch the values:
        try {
            test("F",2).get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Test for exceptions:
        System.out.println(test("G",2).isCompletedExceptionally());
        // Counts as "done":
        System.out.println(test("H",2).isDone());
        //Force an exception:
        CompletableFuture<Integer> cfi = new CompletableFuture<>();
        System.out.println("done? " + cfi.isDone());
        cfi
                .completeExceptionally(new RuntimeException("force"));
        try{
            cfi.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
