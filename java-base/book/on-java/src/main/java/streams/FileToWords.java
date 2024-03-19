package streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class FileToWords {
    public static Stream<String> stream(String filePath) throws Exception{
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));
    }
}
