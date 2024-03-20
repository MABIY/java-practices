package exceptions;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class StreamsAreAutoCloseable {
    public static void main(String[] args) throws IOException {
        try (Stream<String> in = Files.lines(
                        Paths.get("java-base/book/on-java/src/main/java/exceptions/StreamsAreAutoCloseable.java"));
                PrintWriter outfile = new PrintWriter("Results.txxx")) {
            in.skip(5).limit(1).map(String::toLowerCase).forEachOrdered(outfile::println);
        }
    }
}
