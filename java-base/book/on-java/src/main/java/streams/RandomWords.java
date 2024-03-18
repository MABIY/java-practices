package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    public RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fname));

        for (String line : lines.subList(1,lines.size())) {
            for (String word : line.split("[ .?,]+")) {
                words.add(word.toLowerCase());
            }
        }
    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream().collect(Collectors.joining(" " ));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(
                Stream.generate(new RandomWords("Cheese.dat"))
                        .limit(10)
                        .collect(Collectors.joining(" "))

        );
    }
}
