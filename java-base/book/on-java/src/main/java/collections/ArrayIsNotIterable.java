package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author lh
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.println(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3));
        String[] striings = {"A","B","C"};
//        test(striings);
        test(Arrays.asList(striings));
    }
}
