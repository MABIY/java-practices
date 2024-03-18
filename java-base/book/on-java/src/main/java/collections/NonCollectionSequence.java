package collections;

import collections.temp.Pet;
import collections.temp.PetCreator;

import java.util.Iterator;

/**
 * @author lh
 */
class PetSequence{
    protected Pet[] pets = new PetCreator().array(8);
}
public class NonCollectionSequence extends PetSequence{
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}
