package patterns;

/**
 * @author lh
 */
interface Resource {
    int getValue();
    void setValue(int x);
}
final class Singleton {
    private static final class ResourceImpl implements Resource {
        private int i;

        public ResourceImpl(int i) {
            this.i = i;
        }

        @Override
        public  synchronized int getValue() {
            return i;
        }

        @Override
        public  synchronized void setValue(int x) {
            i = x;
        }
    }

    private static class ResourceHolder {
        private static Resource resource = new ResourceImpl(47);
    }

    public static Resource getResource() {
        return ResourceHolder.resource;
    }
}
public class SingletonPattern {
    public static void main(String[] args) {
        Resource r  = Singleton.getResource();
        System.out.println(r.getValue());
        Resource s2  = Singleton.getResource();
        s2.setValue(9);
        System.out.println(r.getValue());
    }
}
