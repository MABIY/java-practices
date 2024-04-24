package collectiontopics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static onjava.HTMLColors.*;

/**
 * @author lh
 */
public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>(LIST.subList(0,4));
        c.add("ten");
        c.add("eleven");
        show(c);
        border();
        // Make an array from the list:
        Object[] array = c.toArray();
        //Make a String array from the list:
        String[] str = c.toArray(new String[0]);
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));
        border();
        // Add a Collection to another Collection
        Collection<String> c2 = new ArrayList<>(LIST.subList(10,14));
        c.addAll(c2);
        show(c);
        border();
        c.remove(LIST.get(0));
        show(c);
        border();
        c.removeAll(c2);
        show(c);
        border();
        c.addAll(c2);
        show(c);
        border();
        String val = LIST.get(3);
        System.out.println("c.contains(" + val + ") = " + c.contains(val));
        System.out.println("c.containsAll(c2) = " + c.containsAll(c2));
        Collection<String> c3 = ((List<String>)c).subList(3,5);
        c2.retainAll(c3);
        show(c2);
        c2.removeAll(c3);
        System.out.println("c2.isEmpty() = " + c2.isEmpty());
        border();
        // Functional operation:
        c = new ArrayList<>(LIST);
        c.removeIf(s -> !s.startsWith("P"));
        c.removeIf(s -> s.startsWith("Pale"));
        // Stream operation:
        c.stream().forEach(System.out::println);
        c.clear(); // Remove all elements
        System.out.println("after c.clear(): " + c);
    }
}
