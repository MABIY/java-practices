package generics;

import java.util.Iterator;

/**
 * @author lh
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.get();
            }

            @Override
            public void remove() {
                Iterator.super.remove();
            }
        };
    }

    public static void main(String[] args){
        for (int s : new IterableFibonacci(18)) {
            System.out.print(s + " ");
        }
    }
}
