package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author lh
 */
public class RandomList<T> extends ArrayList<T> {
    private Random rand =  new Random(47);

    public T select(){
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        rs.addAll(Arrays.asList("The quick brown fox jumped over the lazy brown dogThe quick brown fox jumped over the lazy brown dog".split(" ")));
        IntStream.range(0, 11).forEach(i -> System.out.print(rs.select() + " "));
    }
}
