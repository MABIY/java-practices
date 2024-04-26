package collectiontopics;

import java.util.Objects;
import java.util.WeakHashMap;

/**
 * @author lh
 */
class Element {
    private String ident;

    public Element(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ident);
    }

    @Override
    public boolean equals(Object r) {
        return r instanceof Element && Objects.equals(ident,((Element) r).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String ident) {
        super(ident);
    }
}

class Value extends Element {
    public Value(String ident) {
        super(ident);
    }
}
public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 1000;
        // Or , choose size via the command line:
        if(args.length > 0) {
            size = Integer.valueOf(args[0]);
        }
        Key[] kesy = new Key[size];
        WeakHashMap<Key,Value> map = new WeakHashMap<>();
        for (int i = 0; i <size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if(i%3 ==0) {
                kesy[i] =k;
            }
            map.put(k,v);
        }
        System.gc();
    }
}
