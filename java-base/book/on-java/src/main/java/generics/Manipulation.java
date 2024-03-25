package generics;

/**
 * @author lh
 */
class Manipulator<T> {
    private T obj;

    public Manipulator(T obj) {
        obj = obj;
    }

    public void manipulate() {
//        obj.f();  cannot find symbol: method f():
    }
}
public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
