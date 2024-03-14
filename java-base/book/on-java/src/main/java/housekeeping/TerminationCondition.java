package housekeeping;

import atunit.Nap;

/**
 * @author lh
 */

class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() {
        if(checkedOut){
            System.out.println("Error: check1ed out");
        }
//        super.finalize();
    }
}
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);

        novel.checkIn();
        new Book(true);
        System.gc();
        new Nap(1);
    }
}
