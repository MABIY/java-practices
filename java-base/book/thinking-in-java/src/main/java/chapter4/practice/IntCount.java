package chapter4.practice;


import static util.Print.print;

/**
 * Modify exercise 1 so that the program exit by using the break keyword at
 * value 99. Try using return instead.
 * @author lh
 */
public class IntCount {
    static void count1(int n){
        for(int i = 0; i < n; i++) {
            print(i + 1);

        }
    }

    static void count2(int n){
        for(int i = 0; i < n; i++) {
            print(i + 1);
            if(i == 99)
                break;
        }
    }

    static void count3(int n){
        for(int i = 0; i < n; i++) {
            print(i + 1);
            if(i == 99)
                return;

        }
    }

    public static void main(String[] args){
        count1(100);
        count2(100);
        count3(100);
    }
}
