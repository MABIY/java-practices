package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author lh
 */
public class ShortedSetOfString {
    public static void main(String[] args) {
        Set<String> colors = new TreeSet<>();
        for (int i = 0; i <100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        System.out.println(colors);
    }
}
