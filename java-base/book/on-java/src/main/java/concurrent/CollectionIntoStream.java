package concurrent;

import onjava.Rand;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class CollectionIntoStream {
    public static void main(String[] args) {
        List<String> strings = Stream.generate(new Rand.String(6))
                .limit(10)
                .collect(Collectors.toList());
        strings.forEach(System.out::println);
        // Convert to a Stream for many mroe options:
        String result = strings.stream()
                .map(String::toUpperCase)
                .map(s-> s.substring(2))
                .reduce(":",(s1,s2)-> s1 + s2);
        System.out.println(result);
    }
}
