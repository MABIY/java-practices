package chapter4.practice;
/**
 * A Fibonacci sequence is the sequence of numbers 1,1,2,3,5,8,13,21,34,
 * and so on, where each number (from the third on) is the sum of the previous
 * two. create a method that takes an integer as an argument and displays that
 * many Fibonacci numbers starting from the beginning, e.g., if you run java Fibonacci 5
 * (where Fibonacci is the name of the class) the output will be 1,1,2,3,5
 * @author lh
 */
public class Fibonacci_p04_09 {
    int fib(int n){
        if(n<=2){ return 1;}
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args){
        Fibonacci_p04_09 f =new Fibonacci_p04_09();
        int k =10;
        System.out.println("First " + k + " Fibonacci number(s): ");
        for(int i = 1; i <=k ; i++) {
            System.out.println(f.fib(i));
        }
    }
}
