package objects;

/**
 * @author lh
 */
public class ShowProperties {
    public static void main(String[] args) {
        System.out.println("start");
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
}
