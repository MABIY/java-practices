package arrays;

import onjava.Rand;

import java.util.Arrays;
import java.util.Collections;

import static onjava.ArrayShow.show;


/**
 * @author lh
 */
public class StringSorting {
    public static void main(String[] args) {
        String[] sa = new Rand.String().array(20);
        show("Before sort",sa);
        Arrays.sort(sa);
        show("After sort",sa);
        Arrays.sort(sa, Collections.reverseOrder());
        show("Reverse sort",sa);
        Arrays.sort(sa,String.CASE_INSENSITIVE_ORDER);
        show("Case-insensitive sort",sa);
    }
}
