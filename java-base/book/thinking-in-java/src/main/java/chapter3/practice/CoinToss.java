package chapter3.practice;

import java.util.Random;

import static util.Print.print;

/**
 * Write a program that simulate coin-flipping
 * @author lh
 */
public class CoinToss {
    public static void main(String[] args){
        Random  random = new Random();
        int coin = random.nextInt();
        if(coin %2 == 0)
            print("heads");
        else
            print("tails");
    }
}
