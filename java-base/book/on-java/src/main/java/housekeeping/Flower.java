package housekeeping;

import org.w3c.dom.ls.LSOutput;

/**
 * @author lh
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";

    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor w/ int ar only, petalCount = " + petalCount);
    }

    Flower(String ss) {
        System.out.println("Constructor w/ string arg only, s = " + ss);
    }

    Flower(String s , int petals ) {
        this(petals);
        this.s= s;
        System.out.println("String & int args");
    }

    public Flower() {
        this("hi",47);
        System.out.println("no-arg constructor");
    }

    void printPetalCount() {
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        Flower x= new Flower();
        x.printPetalCount();
    }
}
