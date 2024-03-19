package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws IOException {
        try (Stream<String> a = Files.lines(Paths.get(filePath))) {
            a.skip(1).flatMap(line -> Arrays.stream(line.split("[ .?,]+"))).forEach(w -> builder.add(w));
        }
    }

    public static void main(String[] args) throws IOException {
        new FileToWordsBuilder("Cheese.dat").stream().limit(7).map(w -> w + " ").forEach(System.out::print);
    }

    Stream<String> stream() {
        return builder.build();
    }
}
