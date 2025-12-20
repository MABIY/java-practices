package chapter1.shape;

/**
 * @author lh
 */
public class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    protected void move() {
        System.out.println("Square.move()");
    }
    public static void main(String[] args){
        Shape shape = new Square();
        shape.draw();
        shape.move();
    }

}
