package collectiontopics;

import onjava.Countries;

import java.util.*;

/**
 * @author lh
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names());

    public static void main(String[] args) {
        Collection<String> c= Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c); // Reading is OK
//        c.add("one"); //Can't change it

        List<String> a = Collections.unmodifiableList(
                new ArrayList<>(data)
        );
        ListIterator<String> lit= a.listIterator();
        System.out.println(lit.next()); // Reading is ok
//        lit.add("one"); // Can't change it

        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        System.out.println(s); // Reading is OK
//        s.add("one"); // Can't change it;

        // For a SortedSet:
        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));

        Map<String,String> m = Collections.unmodifiableMap(
                new HashMap<>(Countries.capitals(6))
        );
        System.out.println(m); // Reading is OK
        //m.put("Ralph","Howdy!");
        // For a SrotedMap:
        Map<String, String> sm = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals(6)));
    }
}
