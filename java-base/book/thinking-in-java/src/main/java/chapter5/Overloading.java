package chapter5;

import static util.Print.print;

/**
 * Demonstration of both constructor
 * @author lh
 */
class Tree{
    int height;
    Tree(){
        print("Planting a seeding");
        height = 0;
    }

    public Tree(int initialHeight) {
        this.height = initialHeight;
        print("Creating new Tree that is " +height + " feet tall");
    }

    void info(){
        print("Tree is " + height + " feet tall");
    }

    void info(String s){
       print(s + ": Tree is " + height + " feet tall");
    }
}
public class Overloading {
    public static void main(String[] args){
        for(int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }
        // Overloaded constructor
        new Tree();
    }
}
