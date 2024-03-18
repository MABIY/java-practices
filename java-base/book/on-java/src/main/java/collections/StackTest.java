package collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lh
 */
public class StackTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s : "My Dog has fleas".split(" "))
            stack.push(s);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
