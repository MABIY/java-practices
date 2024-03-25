package generics;

/**
 * @author lh
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;

    public ReturnGenericType(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        ReturnGenericType<HasFImpl> a = new ReturnGenericType<>(new HasFImpl());
        HasFImpl hasF = a.get();
    }
}
