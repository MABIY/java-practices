package strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/
public class TheReplacements {
    public static void main(String[] args) throws IOException {
        String s;
        try (Stream<String> stringStream = Files.lines(
                Paths.get("java-base", "book", "on-java", "src", "main", "java", "strings", "TheReplacements.java"))) {
            s = stringStream.collect(Collectors.joining("\n"));
        }
        // Match specially commented block of test above:
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*", Pattern.DOTALL).matcher(s);
        if (mInput.find()) s = mInput.group(1); // Captured by parentheses
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        // Replace  1+ spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements:
        while (m.find()) {
            m.appendReplacement(sbuf, m.group().toUpperCase());
        }
        // put in the remainder of the text:
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
