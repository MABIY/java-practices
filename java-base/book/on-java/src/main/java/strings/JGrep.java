package strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class JGrep {
    public static void main(String[] args) throws IOException {
        args = new String[] {"java-base/book/on-java/src/main/java/strings/JGrep.java", "[Ssct]\\w+"};
        if (args.length < 2){
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        // Iterate through the lines of the input file:
        int index =0;
        Matcher m= p.matcher("");
        for (String line : Files.readAllLines(Paths.get(args[0]))) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
        }
    }
}
