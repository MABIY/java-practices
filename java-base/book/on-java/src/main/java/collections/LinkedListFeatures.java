package collections;

import collections.temp.Hamster;
import collections.temp.Pet;
import collections.temp.PetCreator;
import collections.temp.Rat;

import java.util.LinkedList;

import static java.lang.System.*;

/**
 * @author lh
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(new PetCreator().list(5));
        out.println(pets);
        out.println("pets.getFirst(): " + pets.getFirst());
        out.println("pets.elements()" + pets.element());
        out.println("pets.peek()" + pets.peek());
        out.println("pets.remove()" + pets.remove());
        out.println("pets.removeFirst()" + pets.removeFirst());
        out.println("pets.poll()" + pets.poll());
        out.println(pets);
        pets.addFirst(new Rat());
        out.println("After addFirst():"+ pets);
        pets.offer(new PetCreator().get());
        out.println("after offer(): " + pets);
        pets.add(new PetCreator().get());
        out.println("after add(): " + pets);
        pets.addLast(new Hamster());
        out.println("after addLast(): " + pets);
        out.println("pets.removeLast(): " + pets.removeLast());
    }
}
