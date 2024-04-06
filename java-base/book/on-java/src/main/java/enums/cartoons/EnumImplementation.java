package enums.cartoons;


import reuse.Car;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author lh
 */
enum CartoonCharacter implements Supplier<CartoonCharacter> {
    SLAPPY, SPANKY,PUNCHY,SILLY,BOUCY,NUTTY,BOB;

    private  Random rand = new Random(47);
    @Override
    public CartoonCharacter get() {
        return values()[rand.nextInt(values().length)];
    }
}
public class EnumImplementation {
    public static <T> void printNext(Supplier<T> rg) {
        System.out.println(rg.get() + ", ");
    }

    public static void main(String[] args) {
        // Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i <10; i++) {
            printNext(cc);
        }
    }
}
