package chapter5.practics;
/**
 * Create a class containing an uninitialization, Exercise 1
 * Create a class containing an unitialized String references.
 * Demonstrate that // this reference is initialized by java to null.
 * @author lh
 */
class Tester{
    String s;
}
public class ConstructorTest_P05_01 {
    public static void main(String[] args){
        Tester t = new Tester();
        System.out.println(t.s);
    }

}
