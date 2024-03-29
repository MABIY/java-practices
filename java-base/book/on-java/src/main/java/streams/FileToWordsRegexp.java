package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class FileToWordsRegexp {
    private final String all;

    public FileToWordsRegexp(String filePath) throws IOException {
        all = Files.lines(Paths.get(filePath)).skip(1).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws IOException {
        FileToWordsRegexp fw = new FileToWordsRegexp("Cheese.dat");
        fw.stream().limit(7).map(w -> w + " ").forEach(System.out::print);
        fw.stream().skip(7).limit(2)
                .map(w -> w + " ").forEach(System.out::print);
    }

    public Stream<String> stream() {
        return Pattern.compile("[ .,?]+").splitAsStream(all);
    }
}
