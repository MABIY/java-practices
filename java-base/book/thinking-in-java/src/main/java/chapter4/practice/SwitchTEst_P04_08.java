package chapter4.practice;

import static util.Print.print;

/**
 * Create a switch statement that prints a message for each case ,and put the
 * switch inside a for loop that tries each case. Put a break after each case
 * and test id, then remove the breaks and see what happens.
 * @author lh
 */
public class SwitchTEst_P04_08 {
    public static void main(String[] args){
        for(int i = 0; i < 11; i++) {
            switch (i){
                case 0: print("zero");break;
                case 1: print("isa");break;
                case 2: print("dalawa");break;
                case 3: print("tatlo");break;
                case 4: print("apat");break;
                case 5: print("lima");break;
                case 6: print("anim");break;
                case 7: print("pito");break;
                case 8: print("walo");break;
                case 9: print("siyam");break;
                default:print("default");
            }
        }
    }
}
