package collectiontopics;

import java.util.*;

/**
 * @author lh
 */
public class Unsupported {
    static void check(String description, Runnable test) {
        try {
            test.run();
        } catch (Exception e) {
            System.out.println(description + "(): " + e);
        }
    }

    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<>(subList);
        check("retainAll", () -> c.retainAll(c2));
        check("removeAll", () -> c.removeAll(c2));
        check("clear", c::clear);
        check("add", () -> c.add("X"));
        check("addAll", () -> c.addAll(c2));
        check("remove", () -> c.remove("C"));
        // The List.set() method modifies the value but
        // doesn't change the size of the data structure
        check("List.set", () -> list.set(0, "x"));
    }

        public static void main(String[] args) {
            List<String> list = Arrays.asList(
                    "A B C D E F H I J K L".split(" ")
            );
            test("Modifiable Copy",new ArrayList<>(list));
            test("Arrays.asList()",list);
            test("unmodifiableList()",Collections.unmodifiableList(new ArrayList<>(list)));
        }
}
