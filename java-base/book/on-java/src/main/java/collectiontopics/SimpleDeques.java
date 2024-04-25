package collectiontopics;

import javax.print.AttributeException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

/**
 * @author lh
 */
class CountString implements Supplier<String> {
    private int n =0;

    public CountString() {
    }

    public CountString(int n) {
        this.n = n;
    }

    @Override
    public String get() {
        return Integer.toString(n++);
    }
}
public class SimpleDeques {
    static void test(Deque<String> deque) {
        CountString s1 = new CountString(),
                s2 = new CountString(20);
        for (int i = 0; i <8; i++) {
            deque.offerFirst(s1.get());
            deque.offerFirst(s2.get());
        }
        System.out.println(deque);
        String result = "";
        while (!deque.isEmpty())  {
            System.out.print(deque.peekFirst() + " ");
            result += deque.pollFirst() +" ";
            System.out.print(deque.peekLast() + " ");
            result += deque.pollLast() +" ";
        }
        System.out.println("\n" + result);
    }

    public static void main(String[] args) {
        int count = 10;
        System.out.println("LinkedList");
        test(new LinkedList<>());
        System.out.println("ArrayDeque");
        test(new ArrayDeque<>());
        System.out.println("LinkedBlockingDeque");
        test(new LinkedBlockingDeque<>(count));
        System.out.println("ConcurrentLinkedDeque");
        test(new ConcurrentLinkedDeque<>());
    }
}
