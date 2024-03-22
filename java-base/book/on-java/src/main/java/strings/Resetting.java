package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lh
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher m= Pattern.compile("[frb][aiu][gx]")
                .matcher("fix the rug with bugs");
        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();
        m.reset("fix the rig with rags");
        while (m.find()) System.out.print(m.group() + " ");
    }
}
