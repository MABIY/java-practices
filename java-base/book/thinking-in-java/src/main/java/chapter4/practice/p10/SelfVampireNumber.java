package chapter4.practice.p10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.Print.print;

/**
 * A vampire number has an even number of digits and is formed by multiplying a
 * pair of number containing half the number of digits for the result.The
 * digits are token from the original number in any order. Pairs of trailing
 * zeros are not allowed. Example include: 1260 = 21 * 60, 1827 = 21 * 87,
 * 2187 = 27 * 81. Write a program that finds all the 4.digit vampire numbers.
 * (Suggested by Dan forhan.)
 * @author lh
 */
public class SelfVampireNumber {
    public static int baiSingleNumber(int value){
        return (value%1000)/100;
    }

    public static int geSingleNumber(int value){
        return value%10;
    }

    public static void main(String[] args){
        for (int i = 1000; i < 9999; i++) {
            int one = qianSingleNumber(i);
            int two = baiSingleNumber(i);
            int three = shiSingleNumber(i);
            int four = geSingleNumber(i);

            printSuccessValue(twoNumberValue(one, two), twoNumberValue(three, four), i);
            printSuccessValue(twoNumberValue(one, two), twoNumberValue(four, three), i);
            printSuccessValue(twoNumberValue(one, three), twoNumberValue(two, four), i);
            printSuccessValue(twoNumberValue(one, three), twoNumberValue(four, two), i);
            printSuccessValue(twoNumberValue(one, four), twoNumberValue(two, three), i);
            printSuccessValue(twoNumberValue(one, four), twoNumberValue(three, two), i);

            printSuccessValue(twoNumberValue(two, one), twoNumberValue(three, four), i);
            printSuccessValue(twoNumberValue(two, one), twoNumberValue(four, three), i);
            printSuccessValue(twoNumberValue(three, one), twoNumberValue(two, four), i);
            printSuccessValue(twoNumberValue(three, one), twoNumberValue(four, two), i);
            printSuccessValue(twoNumberValue(four, one), twoNumberValue(two, three), i);
            printSuccessValue(twoNumberValue(four, one), twoNumberValue(three, two), i);
        }
    }
    public static List<Integer> outputedValues = new ArrayList<>();
    public static void printSuccessValue(int one,int two,int target){
        int product = one * two;
        if (target == product && !outputedValues.contains(product)) {
            outputedValues.add(product);
            print(String.format("%s * %s : %s", one, two, product));
        }
    }

    public static int twoNumberValue(int one ,int two){
        return one*10  + two;
    }



    public static int multiple10(int i){
        return i *10;
    }

    public static int multiple100(int i){
        return i *100;
    }

    public static int multiple1000(int i){
       return i *1000;
    }

    public static int qianSingleNumber(int value){
        return value /1000;
    }

    public static int shiSingleNumber(int value){
        return ((value%1000)%100)/10;
    }

    public static List<Integer>  startOneAllPossible(int one ,int two,int three, int four){
        if(one == 0){
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.add( multiple1000(one) + multiple100(two) + multiple10(three) + four);
        result.add( multiple1000(one) + multiple100(two) + multiple10(four) + three);
        result.add( multiple1000(one) + multiple100(four) + multiple10(two) + three);
        result.add( multiple1000(one) + multiple100(four) + multiple10(three) + two);
        result.add( multiple1000(one) + multiple100(three) + multiple10(two) + four);
        result.add( multiple1000(one) + multiple100(three) + multiple10(four) + two);

        return result;
    }


}
