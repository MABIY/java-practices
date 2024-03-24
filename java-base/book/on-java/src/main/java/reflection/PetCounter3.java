package reflection;

import onjava.Pair;
import reflection.pets.Pet;
import reflection.pets.PetCreator;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lh
 */
public class PetCounter3 {
    static class Counter extends HashMap<Class<? extends Pet>,Integer> {
        public Counter() {
            super(PetCreator.ALL_TYPES.stream().map(type -> Pair.make(type, 0)).collect(Collectors.toMap(Pair::key,Pair::value)));
        }

        public void count(Pet pet) {
            entrySet().stream()
                .filter(pair-> pair.getKey().isInstance(pet))
                    .forEach(pair -> put(pair.getKey(),pair.getValue() +1));
        }
    }
}
