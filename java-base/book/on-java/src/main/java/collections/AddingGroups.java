package collections;

import java.util.*;

/**
 * @author lh
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInts);

        List<Integer> list= Arrays.asList(16,17,18,19,20);
        list.set(1,21);
        ListIterator<Integer> listIterator = list.listIterator();

    }

}
