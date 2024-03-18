package collections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.System.*;

/**
 * @author lh
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i <10000; i++) {
            intSet.add(rand.nextInt(30));
        }
        out.println(intSet);
    }
}
