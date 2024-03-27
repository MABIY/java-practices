package generics;

import reflection.pets.Cat;
import reflection.pets.Dog;
import reflection.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lh
 */
public class CheckedList {
    @SuppressWarnings("unchcked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(),Dog.class);

        try{
            oldStyleMethod(dogs2); // throws an exception
        }catch (Exception e) {
            System.out.println("Excepted: "  + e);
        }

        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(new ArrayList<>(),Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
