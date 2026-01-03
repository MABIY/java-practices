package chapter3;

import static util.Print.print;

/**
 * Demonstrates short-circuiting behavior
 * @author lh
 */
public class ShortCircuit {
    public static void main(String[] args){
        System.out.println();
        boolean b = test1(0) && test2(2) && test3(3);
        print("expression is " +b );
    }

    static boolean test1(int val){
        print("test1(" + val + ")");
        print("result: " + (val < 1) );
        return val < 1;
    }

    static boolean test2(int val){
        print("test2(" + val + ")");
        print("result: " + (val < 2) );
        return val < 2;
    }
    static boolean test3(int val){
        print("test3(" + val + ")");
        print("result: " + (val < 3) );
        return val < 3;
    }
}
