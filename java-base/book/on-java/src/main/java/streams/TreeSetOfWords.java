package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class TreeSetOfWords {
    public static void main(String[] args) throws IOException {
        String[] a = " 1".split(" ");
        Set<String> words;
        try (Stream<String> lines = Files.lines(Paths.get("java-base/book/on-java/src/main/java/streams/TreeSetOfWords.java"))) {
            words = lines.flatMap(s -> Arrays.stream(s.split("\\W+")))
                    .filter(s -> !s.matches("\\d+"))
                    .filter(s -> s.length() > 2)
                    .limit(100)
                    .collect(Collectors.toCollection(TreeSet::new));
        }
        System.out.println(words);
    }
}
