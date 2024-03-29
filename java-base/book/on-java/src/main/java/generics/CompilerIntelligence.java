package generics;

import typeinfo.interfacea.A;

import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);
        flist.contains(new Apple()); //Argument is 'Object'
        flist.indexOf(new Apple()); //Argumetn  is 'Object'
//        flist.add(new Apple());
    }
}
