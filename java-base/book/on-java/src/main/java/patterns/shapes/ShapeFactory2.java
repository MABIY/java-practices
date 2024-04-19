package patterns.shapes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lh
 */
public class ShapeFactory2 implements FactoryMethod{
    Map<String, Constructor<?>> factories = new HashMap<>();
    static Constructor<?> load(String id){
        System.out.println("loading " + id);
        try {
            return Class.forName(String.join(".",ShapeMarker.class.getPackageName(),id))
                    .getConstructor();
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new BadShapeCreation(id);
        }
    }

    @Override
    public Shape create(String id) {
        try {
            return (Shape) factories.computeIfAbsent(id, ShapeFactory2::load)
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BadShapeCreation(id);
        }
    }

    public static void main(String[] args) {
        FactoryTest.test(new ShapeFactory2());
    }

}
