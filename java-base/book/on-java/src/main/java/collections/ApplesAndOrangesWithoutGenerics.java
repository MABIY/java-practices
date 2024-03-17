package collections;

import java.util.ArrayList;

/**
 * @author lh
 */
class Apple {
    private static Long counter;
    private final long id = counter++;
    public Long id(){
        return id;
    }
}

class Orange {}
public class ApplesAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i <3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (Object apple : apples) {
            ((Apple)apple).id();
        }
    }
}
