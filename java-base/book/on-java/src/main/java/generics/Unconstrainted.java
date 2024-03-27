package generics;

/**
 * @author lh
 */
class Other {}
class BasicOther extends BasicHolder<Other>{}
public class Unconstrainted {
    public static void main(String[] args) {
        BasicOther b= new BasicOther();
        BasicOther b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}
