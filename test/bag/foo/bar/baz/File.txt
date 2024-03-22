package files;

import onjava.RmDir;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lh
 */
public class Directories {
    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();

    static List<String>  parts = Arrays.asList("foo","bar","baz","bag");

    static Path makeVariant() {
        Collections.rotate(parts,1);
        return Paths.get("test",String.join(sep,parts));
    }

    static void refreshTestDir() throws IOException {
        if(Files.exists(test))
            RmDir.rmdir(test);
        if(!Files.exists(test))
            Files.createDirectories(test);
    }

    public static void main(String[] args) throws IOException {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        // Throws exception (too many levels)
        try {
            Files.createDirectory(variant);
        } catch (IOException e) {
            System.out.println("Nope, that doesn't work.");
        }
        populateTestDir();
        Path tempDir = Files.createTempDirectory(test,"DIR_");
        Files.createTempFile(tempDir,"pre","non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("**********");
        Files.walk(test).forEach(System.out::println);
    }

    static void populateTestDir() throws IOException {
        for (int i = 0; i <parts.size(); i++) {
            Path vairant = makeVariant();
            if(!Files.exists(vairant)) {
                Files.createDirectories(vairant);
                Files.copy(Paths.get("java-base","book","on-java","src","main","java","files","Directories.java"),vairant.resolve("File.txt"));
                Files.createTempFile(vairant,null,null);
            }
        }
    }
}
