package typeinfo;

/**
 * @author lh
 */
interface Interface {
    void doSometing();

    void somethingElse(String arg);
}
class RealObject implements Interface{
    @Override
    public void doSometing() {
        System.out.println("doSometing");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
class SimpleProxy implements Interface{
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSometing() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSometing();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println(
                "SimpleProxy somethingElse " + arg
        );
        proxied.somethingElse(arg);
    }
}

class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSometing();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}