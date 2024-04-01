package arrays;

import onjava.Rand;

import java.util.Arrays;

import static onjava.ArrayShow.show;

/**
 * @author lh
 */
public class ParallelPrefix1 {
    public static void main(String[] args) {
        int[] nums = new Rand.Pint().array(10);
        show(nums);
        System.out.println(Arrays.stream(nums).reduce(Integer::sum).getAsInt());
        Arrays.parallelPrefix(nums,Integer::sum);
        show(nums);
        System.out.println(Arrays.stream(new Rand.Pint().array(6)).reduce(Integer::sum).getAsInt());
    }
}
