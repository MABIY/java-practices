package housekeeping;

/**
 * @author lh
 */
public class NewVarArgs {
    static void printArray(Object... args) {
        for (Object arg : args) {
            System.out.println(arg + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(47,(float)3.14,11.11);
        printArray(47,3.14f,11.11);
        printArray("one","two","three");
        printArray(new A(),new A(),new A());
        printArray((Object[]) new Integer[]{1,2,3,4});
        printArray();
    }
}
