package arrays;

import java.util.Arrays;
import java.util.Collections;

import static onjava.ArrayShow.show;

/**
 * @author lh
 */
public class Reverse {
    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n-> CompType.get());
        show("Before sorting",a);
        Arrays.sort(a, Collections.reverseOrder());
        show("After sorting",a);

    }
}
