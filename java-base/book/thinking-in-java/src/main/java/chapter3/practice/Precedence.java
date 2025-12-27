package chapter3.practice;
/**
 * @author lh
 */
public class Precedence {
    public static void main(String[] args){
        int x = 1, y = 2 , z= 3;
        int a = x + y - 2 / 2 + z;
        int b = x + (y - 2) / (2 + z);
        Object name =null;
        System.out.println("" + name);
        System.out.println("a = " + a + " b = " + b);
    }
}
