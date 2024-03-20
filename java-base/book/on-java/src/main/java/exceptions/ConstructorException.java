package exceptions;

/**
 * @author lh
 */
class CE extends Exception {}
class SecondExcept extends Reporter{
    public SecondExcept() throws CE {
        throw new CE();
    }
}
public class ConstructorException {
    public static void main(String[] args) {
        try(
                First f =new First();
                SecondExcept s = new SecondExcept();
                Second s2 = new Second();
                ) {
            System.out.println("In body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }
    }
}
