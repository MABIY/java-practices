package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        // Wildcards allows covariance:
        List<? extends Fruit> flist = new ArrayList<>();
        // Compile Error: can't add any type of object:
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        flist.add(null); // Legal but uninteresting
        // we know it returns at least fruit:
        Fruit f = flist.get(0);
    }
}
