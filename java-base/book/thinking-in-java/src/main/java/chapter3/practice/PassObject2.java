package chapter3.practice;

import static util.Print.print;

/**
 * Create a class containing a float and use it to demonstrate aliasing during
 * method calls
 * @author lh
 */
class Box{
    float a;
}
public class PassObject2 {
    static void f(Box y){
        y.a = 2.71828f;
    }
    public static void main(String[] args){
        Box b = new Box();
        b.a = 3.1416f;
        print("1: b.a = " + b.a);
        f(b);
        print("1: b.a = " + b.a);
    }
}
