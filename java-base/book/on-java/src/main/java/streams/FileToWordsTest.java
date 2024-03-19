package streams;

/**
 * @author lh
 */
public class FileToWordsTest {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("Cheese.dat").limit(7).forEach(s -> System.out.printf("%s ", s));
        System.out.println();
        FileToWords.stream("Cheese.dat").skip(7).limit(2).forEach(s -> System.out.printf("%s ", s));
    }
}
