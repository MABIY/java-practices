package arrays;

import java.util.Arrays;
import java.util.SplittableRandom;

import static onjava.ArrayShow.show;

/**
 * @author lh
 */
public class CompType implements Comparable<CompType>{
    private static int count=1;
    private static SplittableRandom r = new SplittableRandom(47);

    int i;
    int j;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static CompType get(){
        return new CompType(r.nextInt(100),r.nextInt(100));
    }

    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a,n-> get());
        show("Before sorting",a);
        Arrays.sort(a);
        show("After sorting",a);

    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if(count++ % 3 ==0) result +="\n";
        return result;
    }

    @Override
    public int compareTo(CompType o) {
        return (Integer.compare(i, o.i));
    }
}
