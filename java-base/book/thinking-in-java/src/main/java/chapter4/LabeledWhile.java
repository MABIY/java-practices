package chapter4;

import static util.Print.print;

/**
 * While loops with "labeled break" and "labeled continue."
 * @author lh
 */
public class LabeledWhile {
    public static void main(String[] args){
        int i =0;
        outer:
        for(;;){
            print("Outer while loop");
            for (; ; ) {
                i++;
                print("i = " + i);
                if (i == 1) {
                    print("continue");
                    continue;
                }
                if (i == 3) {
                    print("continue outer");
                    continue outer;
                }
                if (i == 5) {
                    print("break");
                    break;
                }
                if (i == 7) {
                    print("break outer");
                    break outer;
                }
            }
            System.out.println("inner loop end i value:"+i);
        }
    }
}
