package collectiontopics;

import onjava.CountMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lh
 */
public class MapOps {
    public static void printKeys(Map<Integer, String> map) {
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys: ");
        // Produce a Set of the keys:
        System.out.println(map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        System.out.println(map.getClass().getSimpleName());
        CountMap a = new CountMap(25);
        map.putAll(a);
        // Map has 'Set' behavior for keys:
        CountMap b = new CountMap(25);
        map.putAll(b);
        printKeys(map);
        // Producing a Collection of the values
        System.out.println("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue(\"FO\"): " + map.containsValue("FO"));
        Integer key = map.keySet().iterator().next();
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountMap(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());
    }

        public static void main(String[] args) {
            test(new HashMap<>());
            test(new TreeMap<>());
            test(new LinkedHashMap<>());
            test(new IdentityHashMap<>());
            test(new ConcurrentHashMap<>());
            test(new WeakHashMap<>());
        }
}
