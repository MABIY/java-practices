package chapter4.practice;

import java.util.Random;

import static util.Print.print;

/**
 * Modify exercise 2 with infinte while loop. Stop program with Ctrl-C
 * @author lh
 */
public class CompareIntsForever_P04_03 {
    public static void main(String[] args){
        Random rand1  = new Random();
        Random rand2 = new Random();
        for(int i = 0; i < 25; i++) {
            int x = rand1.nextInt();
            int y = rand2.nextInt();
            if (x < y) print(x + " < " + y);
            else if(x > y) print(x + " > " +y);
            else print(x + " = " + y);
        }

        Random rand3 = new Random();
        Random rand4 = new Random();
        while (true){
            int x =rand3.nextInt(10);
            int y =rand3.nextInt(10);
            if (x < y) print(x + " < " + y);
            else if (x > y) print(x + " > " + y);
            else print(x + " = " + y);
        }

    }

}
