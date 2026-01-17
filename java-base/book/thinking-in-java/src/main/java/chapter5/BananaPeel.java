package chapter5;
/**
 * @author lh
 */
class Banana {
    void peel(int i) {
        System.out.println("i value:" + i);
    }
}

public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(), b = new Banana();
        a.peel(1);
        a.peel(2);
    }
}
