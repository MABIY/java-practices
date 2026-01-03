package chapter3.practice;

import static util.Print.print;

/**
 * Show that hex and octal notations work with long values.
 * @author lh
 */
public class LongValues {
    public static void main(String[] args){
        long n1 = 0xffff; // hexadecimal
        long n2 = 0177777; //octal
        print("long n1 in hex = " + Long.toBinaryString(n1));
        print("long n2 in oct = " + Long.toBinaryString(n2));
    }
}
