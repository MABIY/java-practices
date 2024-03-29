package reuse;

import java.util.Random;

/**
 * @author lh
 */
class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }

}
public class FinalData {
    private static Random rand =  new Random(37);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    // Can be compile-time constants
    private final int valueOne =9;
    private static final int VALUE_TWO = 99;
    // Typical public constant:
    public static final int VALUE_THREE=39;
    // Cannot be compile-time constants
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);

}
