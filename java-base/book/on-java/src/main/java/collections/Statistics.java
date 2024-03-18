package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author lh
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i <10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.getOrDefault(r,1);
            m.put(r, freq+1);
        }
        System.out.println(m);
    }

}
