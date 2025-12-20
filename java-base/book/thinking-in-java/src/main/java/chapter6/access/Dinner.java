package chapter6.access;

import chapter6.access.dessert.Cookie;
import org.checkerframework.checker.units.qual.C;

/**
 * @author lh
 */
public class Dinner {
    public static void main(String[] args){
        Cookie x = new Cookie();
        //! x.bite(); // Can't access
    }
}
