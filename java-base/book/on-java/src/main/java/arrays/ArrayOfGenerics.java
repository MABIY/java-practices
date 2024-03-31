package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 */
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la; // Unchecked cast
        ls[0] = new ArrayList<>();
//        ls[1] =new ArrayList<Integer>();

        // The problems: List<String> is a subtype of Object
        Object[] objects = ls; // So assignment is ok
        // compiles and runs without complaint:
        objects[1] = new ArrayList<>();

        List<BerylliumSphere>[] sphers = (List<BerylliumSphere>[]) new List[10];
        Arrays.setAll(sphers,n -> new ArrayList<>());
    }
}
