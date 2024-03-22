package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author lh
 */
public class ListOfLines {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("Cheese.dat")).stream()
                .filter(line -> !line.startsWith("//"))
                .map(line -> line.substring(0, line.length() / 2))
                .forEach(System.out::println);
    }
}
