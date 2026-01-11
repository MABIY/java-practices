package chapter4;

import javax.swing.*;

import static util.Print.print;

/**
 * @author lh
 */
public class IfElse2 {
    static int test(int testval,int target){
        return Integer.compare(testval, target);
    }

    public static void main(String[] args) {
        print(test(10,5));
        print(test(5,10));
        print(test(5,5));

    }
}
