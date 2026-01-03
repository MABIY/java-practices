package chapter3.practice;

import static util.Print.print;

/**
 * Start with a number that is all binary ones. Left shift it , then use the
 * unsigned right-shift operator to right shift through all of its bianry
 * positions,each time displaying the result using Integer.toBinarySing().
 * @author lh
 */
public class RightShift_P03_12 {
    public static void main(String[] args){
        int h = -1;
        print(Integer.toBinaryString(h));
        h <<= 10;
        print(Integer.toBinaryString(h));
        for(int i = 0; i < 32; i++) {
            h >>>= 1;
            print(Integer.toBinaryString(h));
        }
    }
}
