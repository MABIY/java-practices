package patterns.shapes;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author lh
 */
interface PolymorphicFactory {
    Shape create();
}

class RandomShapes implements Supplier<Shape> {
    private Random random = new Random(42);
    public RandomShapes(PolymorphicFactory... factories) {
        this.factories = factories;
    }

    private final PolymorphicFactory[] factories;
    @Override
    public Shape get() {
        return factories[random.nextInt(factories.length)].create();
    }
}
public class ShapeFactory3 {
    public static void main(String[] args) {
        RandomShapes rs = new RandomShapes(
                Circle::new,Square::new
                ,Triangle::new
        );
        Stream.generate(rs)
                .limit(6)
                .filter(shape -> true)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .count();
    }
}
