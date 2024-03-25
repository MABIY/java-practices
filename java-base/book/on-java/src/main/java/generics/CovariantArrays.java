package generics;

/**
 * @author lh
 */

class Fruit {}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        // Runtime type is Apple[], not Fruit[] or Orange[];
        try {
            // Compiler allow you to add Fruit:
            fruits[0] = new Fruit(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
        try{
            // Compiler allow you to add Fruit:
            fruits[0] = new Orange(); // ArrayStoreException
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
