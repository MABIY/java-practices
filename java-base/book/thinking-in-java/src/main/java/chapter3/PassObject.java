package chapter3;

import static util.Print.print;

/**
 * Passing objects to methods may not be
 * what you're used to
 * @author lh
 */
class Letter{
    char c;
}
public class PassObject {
    static void f(Letter y){
        y.c = 'z';
    }

    public static  void main(String[] args){
        Letter y = new Letter();
        y.c = 'a';
        print("1: y.c: " + y.c);
        f(y);
        print("2: y.c: " + y.c);
    }

}
