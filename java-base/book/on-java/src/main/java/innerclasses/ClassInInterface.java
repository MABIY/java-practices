package innerclasses;

/**
 * @author lh
 */
public interface ClassInInterface {
     void howdy();
     class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
