package enums;


import java.util.Random;

/**
 * @author lh
 */

// Demonstration of multiple dispatching
interface Item {
    OutCome compete(Item it);

    OutCome eval(Paper it);

    OutCome eval(Scissors s);

    OutCome eval(Rock r);
}

class Paper implements Item {
    @Override
    public OutCome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public OutCome eval(Paper it) {
        return OutCome.DRAW;
    }

    @Override
    public OutCome eval(Scissors s) {
        return OutCome.WIN;
    }

    @Override
    public OutCome eval(Rock r) {
        return OutCome.LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}

class Scissors implements Item {
    @Override
    public OutCome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public OutCome eval(Paper it) {
        return OutCome.LOSE;
    }

    @Override
    public OutCome eval(Scissors s) {
        return OutCome.DRAW;
    }

    @Override
    public OutCome eval(Rock r) {
        return OutCome.WIN;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}

class Rock implements Item {
    @Override
    public OutCome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public OutCome eval(Paper it) {
        return OutCome.WIN;
    }

    @Override
    public OutCome eval(Scissors s) {
        return OutCome.LOSE;
    }

    @Override
    public OutCome eval(Rock r) {
        return OutCome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}

public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)){
            default:
            case 0: return new Scissors();
            case 1: return new Paper();
            case 2: return new Rock();
        }
    }

    public static void match(Item a,Item b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b)) ;
    }

    public static void main(String[] args) {
        for (int i = 0; i <SIZE; i++) {
            match(newItem(),newItem());
        }
    }
}
