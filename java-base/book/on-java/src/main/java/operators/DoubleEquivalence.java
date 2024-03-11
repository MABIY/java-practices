package operators;

/**
 * @author lh
 */
public class DoubleEquivalence {
    static void show(String desc, Double n1, Double n2) {
        System.out.println(desc + ":");
        System.out.printf("%e==%e %b %b%n", n1, n2, n1 == n2, n1.equals(n2));
    }

    public static void main(String[] args) {
        Double a = Double.MIN_VALUE  * 1_000_000;
    }
}
