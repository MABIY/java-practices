package streams;

import java.io.IOException;
import java.util.Comparator;

/**
 * @author lh
 */
public class SortedComparator {
    public static void main(String[] args) throws IOException {
        FileToWordsRegexp fw = new FileToWordsRegexp("Cheese.dat");
        fw.stream()
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
