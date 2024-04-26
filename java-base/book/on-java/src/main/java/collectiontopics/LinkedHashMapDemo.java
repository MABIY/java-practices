package collectiontopics;

import onjava.CountMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lh
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedMap = new LinkedHashMap<>(new CountMap(9));
        System.out.println(linkedMap);

        // Least-recently-used order:
        linkedMap = new LinkedHashMap<>(16,0.75f,true);
        linkedMap.putAll(new CountMap(9));
        System.out.println(linkedMap);
        for (int i = 0; i <6; i++) {
            linkedMap.get(i);
        }
        System.out.println(linkedMap);
        String value = linkedMap.get(0);
        System.out.println(value);
        System.out.println(linkedMap);
        for (Map.Entry<Integer, String> integerStringEntry : linkedMap.entrySet()) {
            System.out.println(integerStringEntry);
        }
    }
}
