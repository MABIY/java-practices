package arrays;

import java.util.Arrays;

import static onjava.ArrayShow.show;

/**
 * @author lh
 */
class Bob {
    final int id;

    public Bob(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bob" + id;
    }
}

public class SimpleSetAll {
    public static final int SZ = 8;
    static int val = 1;
    static char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char getChar(int n) {
        return chars[n];
    }

    public static void main(String[] args) {
        int[] ia = new int[SZ];
        long[] la = new long[SZ];
        double[] da = new double[SZ];
        Arrays.setAll(ia,n->n);
        Arrays.setAll(la,n->n);
        Arrays.setAll(da,n->n);
        show(ia);
        show(la);
        show(da);
        Arrays.setAll(ia,n-> val++);
        Arrays.setAll(la,n-> val++);
        Arrays.setAll(da,n-> val++);
        show(ia);
        show(la);
        show(da);

        Bob[] ba = new Bob[SZ];
        Arrays.setAll(ba,Bob::new);
        show(ba);

        Character[] ca = new Character[SZ];
        Arrays.setAll(ca,SimpleSetAll::getChar);
        show(ca);
    }
}
