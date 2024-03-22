package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class ReadLineStream {
    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(
                Paths.get("java-base", "book", "on-java", "src", "main", "java", "files", "PathInfo.java"))) {
            lines.skip(13).findFirst().ifPresent(System.out::println);
        }
    }
}
