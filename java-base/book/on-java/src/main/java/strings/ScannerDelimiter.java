package strings;

import java.util.Scanner;

/**
 * @author lh
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNext()) {
            System.out.println(scanner.nextInt());
        }
    }
}
