package innerclasses.controller;

/**
 * @author lh
 */
class WithInner {
    class Innner{}
}
public class InheritInner  extends WithInner.Innner{
    public InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi  = new WithInner();
        InheritInner li = new InheritInner(wi);
    }
}
