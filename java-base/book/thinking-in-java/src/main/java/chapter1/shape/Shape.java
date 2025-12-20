package chapter1.shape;

/**
 * @author lh
 */
public abstract class Shape {
    private void erase() {
        System.out.println("Shape.erase()");
    }

    void draw() {
        System.out.println("Shape.draw()");
    }

    protected void move() {
        System.out.println("Shape.move()");
    }



    public void test(){
        this.erase();
        this.draw();
        this.move();
    }




}
