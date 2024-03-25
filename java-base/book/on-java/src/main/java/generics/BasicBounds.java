package generics;

import java.awt.*;

/**
 * @author lh
 */
interface HasColor {
    java.awt.Color getColor();
}

class WithColor<T extends HasColor> {
    T item;

    public WithColor(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    // the bound allows you to call a method:
    java.awt.Color color(){
        return item.getColor();
    }
}

class Coord {
    public int x,y,z;
}

// This fails. Class mut be first. then interfaces:
//class WihtColorCoord<T extends HasColor & Coord> {
//
//}

// Multiple bounds:
class WithColorCoord<T extends Coord & HasColor>{
    T item;

    public WithColorCoord(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

// As with inheritance,you can have only one
// concrete class but multiple interface:
class Solid<T extends Coord & HasColor & Weight> {
    T item;

    public Solid(T item) {
        this.item = item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    public T getItem() {
        return item;
    }

    int getX() {
        return item.x;
    }
    int getY() {
        return item.y;
    }
    int getZ() {
        return item.z;
    }

    int weight(){
        return item.weight();
    }
}

class Bounded extends Coord implements HasColor,Weight {
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
public class BasicBounds {

    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
