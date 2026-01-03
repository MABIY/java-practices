package chapter3;
/**
 *
 * Surprise! java lets you overflow.
 * @author lh
 */
public class Overflow {
    public static void main(String[] args){
        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);
        int bigger = big *4;
        System.out.println("bigger = " + bigger);
    }
}
