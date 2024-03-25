package generics;

/**
 * @author lh
 */
public class GenericHolder2<T> {
    private T obj;

    public void set(T obj){
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        GenericHolder2<String> holder = new GenericHolder2<>();
        holder.set("item");
        String s = holder.get();
    }
}
