package chapter5.practics;

import org.checkerframework.checker.units.qual.A;

/**
 * @author lh
 */
class Aso{
    void bark(){
        System.out.println("woof");
    }
}
public class AutomaticConstructor_P05_07 {
    public static void main(String[] args){
        Aso a = new Aso();
        a.bark();
    }

}
