package enums;

/**
 * @author lh
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Object enumConstant : intClass.getEnumConstants()) {
                System.out.println(enumConstant);
            }
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}
