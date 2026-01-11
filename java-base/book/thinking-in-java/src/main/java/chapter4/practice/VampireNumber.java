package chapter4.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * A vampire number has an even number of digits and is formed by multiplying a
 * pair of number containing half the number of digits for the result.The
 * digits are token from the original number in any order. Pairs of trailing
 * zeros are not allowed. Example include: 1260 = 21 * 60, 1827 = 21 * 87,
 * 2187 = 27 * 81. Write a program that finds all the 4.digit vampire numbers.
 * (Suggested by Dan forhan.)
 * @author lh
 */
public class VampireNumber {
    public static String exchange(String intStr){
        if(intStr.length()==1){
            intStr = "0"+intStr;
        }
        char first = intStr.charAt(0);
        char two = intStr.charAt(1);
        return two+""+first;
    }

    public static void main(String[] args){
        List<Integer> results = new ArrayList<>();
        for(int i = 10; i <= 99; i++) {
            for(int j = 10; j <=99 ; j++) {
                List<Integer> values = List.of(
                        Integer.valueOf(i + "" + j),
                        Integer.valueOf(i + exchange(String.valueOf(j))),
                        Integer.valueOf(exchange(String.valueOf(i) + j)),
                        Integer.valueOf(exchange(i + exchange(String.valueOf(j))))

                        Integer.valueOf(j + "" + i),
                        Integer.valueOf(j + exchange(String.valueOf(i))),
                        Integer.valueOf(exchange(String.valueOf(j) + i)),
                        Integer.valueOf(exchange(j + exchange(String.valueOf(i)))));

                int one  =i;
                int two = j;
                tryPrintSuccess(values, one, two);
                two = Integer.valueOf(exchange(String.valueOf(two)));
                tryPrintSuccess(values, one, two);

                one = Integer.valueOf(exchange(String.valueOf(one)));
                tryPrintSuccess(values, one, two);
                two = Integer.valueOf(exchange(String.valueOf(two)));
                tryPrintSuccess(values, one, two);

                one=j;
                two=j;
                tryPrintSuccess(values, one, two);

            }
        }
    }

    private static void tryPrintSuccess(List<Integer> values, int one, int two) {
        if(values.contains(one * two)){
            System.out.println("target:"+ one * two +"one:"+ one +" two:" + two);
        }
    }

}
