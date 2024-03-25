package generics.coffee;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class CoffeeSupplier implements Supplier<Coffee>,Iterable<Coffee> {
    private Class<?>[] types = {
            Latte.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class
    };

    private static Random rand = new Random(47);

    public CoffeeSupplier() {
    }

    // For iteration:
    private int size =0;

    public CoffeeSupplier(int size) {
        this.size = size;
    }


    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee get() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier()).limit(5).forEach(System.out::println);
        for (Coffee coffee : new CoffeeSupplier(5)) {
            System.out.println(coffee);
        }
    }
}
