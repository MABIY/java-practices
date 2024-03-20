package exceptions;

/**
 * @author lh
 */
class Annoyance extends Exception{}
class Sneeze extends Annoyance{}
public class Human {
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Annoyance e) {
            throw new RuntimeException(e);
        }
//        catch (Sneeze e) {
//           throw new RuntimeException(e);
//        }
    }
}
