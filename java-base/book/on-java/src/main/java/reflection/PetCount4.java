package reflection;

import reflection.pets.Pet;
import reflection.pets.PetCreator;

/**
 * @author lh
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        new PetCreator().stream().limit(20).peek(counter::count).forEach(p -> System.out.print(p.getClass().getSimpleName()+ " "));
        System.out.println("\n" +counter);
    }
}
