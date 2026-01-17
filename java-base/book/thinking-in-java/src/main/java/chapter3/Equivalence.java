package chapter3;
/**
 * @author lh
 */
public class Equivalence {
    @SuppressWarnings("removal")
    public static void main(String[] args){
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
    }
}
