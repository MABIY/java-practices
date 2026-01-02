package chapter3;

import static util.Print.print;

/**
 * Demonstrates the ++ and -- operators
 * @author lh
 */
public class AutoInc {
    public static void main(String[] args){
        int i =1;
        print("i : " + i);
        print("++i : " + ++i); // Pre-increment
        print("i++ : " + i++); // Post-increment
        print("i : " + i);
        print("--i : " +  --i); //Pre-decrement
        print("i-- : " + i--); //Post-decrement
        print("i : " + i);
    }
}
