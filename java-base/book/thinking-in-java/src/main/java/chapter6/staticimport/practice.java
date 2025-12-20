package chapter6.staticimport;

import static chapter6.staticimport.ShouldStaticImportClass.InnerShouldImportClass.INNER_STATIC_VALUE;
import static chapter6.staticimport.ShouldStaticImportClass.STATIC_VALUE;

/**
 * @author lh
 */
public class practice {
    public static void main(String[] args){
        System.out.println(STATIC_VALUE);
        System.out.println(INNER_STATIC_VALUE);
    }
}
