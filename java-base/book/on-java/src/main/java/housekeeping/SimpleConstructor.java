package housekeeping;

/**
 * @author lh
 */
class Rock {
    public Rock() {
        System.out.print("Rock ");
    }
}
public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            new Rock();
        }
    }
}
