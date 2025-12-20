package chapter1;

import chapter1.shape.Shape;
import chapter1.shape.Square;

/**
 * @author lh
 */
public class ShapeImpl extends Shape {
    void draw() {
        System.out.println("ShapeImpl.draw()");
    }

    @Override
    protected void move() {
        System.out.println("ShapeImpl.move()");
    }

}
