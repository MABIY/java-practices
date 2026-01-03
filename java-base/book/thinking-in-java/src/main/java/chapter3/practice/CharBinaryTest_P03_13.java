package chapter3.practice;

import static util.Print.print;

/**
 * Write a method that displays char values in binary form, Demonstrate it
 * using several different characters.
 * @author lh
 */
public class CharBinaryTest_P03_13 {
    public static void main(String[] args) {
        char c = 'a';
        print(Integer.toBinaryString(c));
        c = 'b';
        print(Integer.toBinaryString(c));
        c = 'c';
        print(Integer.toBinaryString(c));
        c = 'd';
        print(Integer.toBinaryString(c));
        c += 1;
        print(Integer.toBinaryString(c));
        c = 'A';
        print(Integer.toBinaryString(c));
        for (int i = 0; i < 25; i++) {
            c += 1;

            print("char: " + c + " value:" + Integer.toBinaryString(c));
        }
    }
}
