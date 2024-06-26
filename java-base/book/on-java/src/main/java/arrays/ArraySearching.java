package arrays;

import onjava.Rand;

import java.util.Arrays;

import static onjava.ArrayShow.show;

/**
 * @author lh
 */
public class ArraySearching {
    public static void main(String[] args) {
        Rand.Pint rand = new Rand.Pint();
        int[] a = new Rand.Pint().array(25);
        Arrays.sort(a);
        show("Sorted",a);
        while (true) {
            int r = rand.getAsInt();
            int location = Arrays.binarySearch(a,r);
            if(location >=0){
                System.out.println("Location of " + r + " is " +
                        location + ", a[" + location + "] is " + a[location]);
                break;
            }
        }
    }
}
