package chapter3.practice;

import static util.Print.print;

/**
 * Start with a number that has a binary one in the most significant position
 * (hints: use a hexadeciaml constant). Using the signed right-shift operator,
 * right shift it all the way through all the binary position each time
 * displaying the result using Integer.toBinaryString().
 * @author lh
 */
public class RightShiftTest_P03_11 {
    public static void main(String[] args){
        int h = 0x10000000;
        print(Integer.toBinaryString(h));
        for(int i = 0; i < 29; i++) {
            h >>>=1;
            print(Integer.toBinaryString(h));
        }
    }
}
