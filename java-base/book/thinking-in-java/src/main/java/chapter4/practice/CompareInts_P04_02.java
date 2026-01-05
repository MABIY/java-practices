package chapter4.practice;

import java.util.Random;

/**
 * @author lh
 */
public class CompareInts_P04_02 {
    public static void main(String[] args){
//        Random rand1 =  new Random();
//        Random rand2=  new Random();
//        for(int i = 0; i < 25; i++) {
//            int x = rand1.nextInt();
//            int y = rand1.nextInt();
//            if(x < y) print(x + " < " +y);
//            else if(x > y) print(x + " > "+y);
//            else print(x + " = " + y);
//        }
//
//        Random rand3 = new Random();
//        Random rand4 = new Random();
//        for(int i = 0; i < 25; i++) {
//            int x = rand3.nextInt(10);
//            int y = rand4.nextInt(10);
//            if(x <y) print(x + " < " + y);
//            else if(x >y) print(x + " > " +y);
//            else print(x + " = " +y);
//        }
//

        Random random1 = new Random();
        Integer before,current = null;
        for(int i = 0; i < 25; i++) {
            before = current;

            current = random1.nextInt();
            if(i==0){
                continue;
            }

            if(current > before){
                System.out.println("current > before");
            }else if(current < before){
                    System.out.println("current < before");
            }else {
                System.out.println("current = before");
            }
        }

    }
}
