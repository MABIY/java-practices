package arrays;

import onjava.Rand;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.SimpleTimeZone;

import static onjava.ArrayShow.show;

/**
 * @author lh
 */
class Sup {
    // Superclass
    private int id;

    public Sup(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }
}

class Sub extends Sup {
    public Sub(int id) {
        super(id);
    } // Subclass

}
public class ArrayCopying {
    public static final int SZ = 15;
    public static void main(String[] args) {
        int[] a1 = new int[SZ];
        Arrays.setAll(a1, new Rand.Integer()::get);
        show("a1",a1);
        int[] a2 = Arrays.copyOf(a1,a1.length);
        // Prove they are distinct arrays:
        Arrays.fill(a1,1);
        show("a1",a1);
        show("a2",a2);
        // Create a shorter result:
        a2 = Arrays.copyOf(a2, a2.length/2);
        show("a2",a2);
        // Allocate more space:
        a2 = Arrays.copyOf(a2, a2.length+5);
        show("a2",a2);
        // Also copies wrapped arrays
        Integer[] a3 = new Integer[SZ];
        Arrays.setAll(a3,new Rand.Integer()::get);
        Integer[] a4 = Arrays.copyOfRange(a3,4,12);
        show("a4",a4);
        Sub[] d = new Sub[SZ/2];
        Arrays.setAll(d,Sub::new);
        Sup[] b = Arrays.copyOf(d,d.length,Sup[].class);
        show(b); // this "downcast" works fine:
        Sub[] d2 = Arrays.copyOf(b,b.length,Sub[].class);
        show(d2);
        Sup[] b2 = new Sup[SZ/2];
        Arrays.setAll(b2,Sup::new);
        try{
            Sub[] d3 = Arrays.copyOf(b2,b2.length,Sub[].class);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
