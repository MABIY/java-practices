package generics;

/**
 * @author lh
 */
public class GenericHolder<T> {
    private T a;

    public GenericHolder() {
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        h3.set(new Automobile()); //无需类型转换
        Automobile a = h3.get();
//        h3.set("Not an Automobiel");
//        h3.set(1);
    }
}
