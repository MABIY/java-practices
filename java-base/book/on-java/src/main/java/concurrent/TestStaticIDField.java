package concurrent;

/**
 * @author lh
 */
public class TestStaticIDField {
    public static void main(String[] args) {
        IDChecker.test(StaticIDField::new);
    }
}
