package streams;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author lh
 */
public class ImperativeRandoms {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r =rand.nextInt(5,20);
            rints.add(r);
        }
        System.out.println(rints);
    }
}
