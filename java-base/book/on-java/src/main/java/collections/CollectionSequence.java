package collections;

import collections.temp.Pet;
import collections.temp.PetCreator;

import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author lh
 */
public class CollectionSequence<T> extends AbstractCollection<T> {
    private Pet[] pets = new PetCreator().array(8);
    @Override
    public int size() {
        return pets.length;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index =0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public T next() {
                T pet = (T) pets[index++];
                return pet;
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        CollectionSequence<Pet> c = new CollectionSequence<>();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
