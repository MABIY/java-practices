package enums;

import onjava.Enums;

/**
 * @author lh
 */
enum Activity {SITTING,LYING,STANDING,HOPPING,RUNNING,DODGING,JUMPING,FALLING,FLYING}
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i <20; i++) {
            System.out.print(Enums.rand(Activity.class) + " ");
        }
    }
}
