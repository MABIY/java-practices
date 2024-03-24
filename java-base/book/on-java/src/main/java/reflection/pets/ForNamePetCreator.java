package reflection.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 */
public class ForNamePetCreator extends Creator {
    private static final List<Class<? extends Pet>> types = new ArrayList<>();

    private static final String[] typeNames = {
        "reflection.pets.Mtt",
        "reflection.pets.Pug",
        "reflection.pets.EgyptianMau",
        "reflection.pets.Manx",
        "reflection.pets.Cymric",
        "reflection.pets.Rat",
        "reflection.pets.Mouse",
        "reflection.pets.Hamster",
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String typeName : typeNames) {
                types.add((Class<? extends  Pet>) Class.forName(typeName));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
