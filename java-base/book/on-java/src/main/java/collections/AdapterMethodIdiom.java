package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author lh
 */
class ReversibleArrayList<T>  extends ArrayList<T> {
    public ReversibleArrayList(Collection<? extends T> c) {
        super(c);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int index = size() -1;
                    @Override
                    public boolean hasNext() {
                        return index>-1;
                    }

                    @Override
                    public T next() {
                        return get(index--);
                    }
                };
            }
        };
    }
}
public class AdapterMethodIdiom{
    public static void main(String[] args) {
        ReversibleArrayList<String> ra1 = new ReversibleArrayList<>(
                Arrays.asList("To be or not to be".split(" "))
        );
        for (String s : ra1) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : ra1.reversed()) {
            System.out.print(s + " ");
        }
    }
}
