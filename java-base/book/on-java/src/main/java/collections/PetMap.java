package collections;

import reflection.pets.Cat;
import reflection.pets.Dog;
import reflection.pets.Hamster;
import reflection.pets.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lh
 */
public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat",new Cat("Molly"));
        petMap.put("My Dog",new Dog("Ginger"));
        petMap.put("My Hamster",new Hamster("Bosco"));
        System.out.println(petMap);
        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}
