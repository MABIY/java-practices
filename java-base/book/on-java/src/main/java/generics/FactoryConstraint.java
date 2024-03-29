package generics;

import onjava.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author lh
 */
class IntegerFactory implements Supplier<Integer> {
    private int i =0;

    @Override
    public Integer get() {
        return ++i;
    }
}

class Widget{
    private int id;

    public Widget(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Widget " + id;
    }

    public static class Factory implements Supplier<Widget> {
        @Override
        public Widget get() {
            return new Widget(++i);
        }

        private int i = 0;
    }
}

class Fudge{
    private static int count =1;
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge " +n;
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();

    public Foo2(Supplier<T> factory) {
        Suppliers.fill(x,factory,5);
    }

    @Override
    public String toString() {
        return x.toString();
    }
}
public class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(
                new Foo2<>(new IntegerFactory())
        );
        System.out.println(
                new Foo2<>(new Widget.Factory())
        );
        System.out.println(
                new Foo2<>(Fudge::new)
        );
    }
}
