package chapter3.practice;
/**
 * Display the largest and smallest numbers for both float and double
 * exponential notation.
 * @author lh
 */
public class MinMax_P03_09 {
    public static void main(String[] args){
        double max = Double.MAX_VALUE;
        System.out.println("max double = "+max);
        double min = Double.MIN_VALUE;
        System.out.println("min double = "+min);
        float maxf= Float.MAX_VALUE;
        System.out.println("max float = " + maxf);
        float mixf = Float.MIN_VALUE;
        System.out.println("mix float = " + mixf);
        if(true ^ false){
            System.out.println("yes");
        }

    }
}
