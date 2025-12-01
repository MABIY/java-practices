package chapter2.practice;
/**
 * In hte Initializaion and cleanup chapter, locate the Overloading.java
 * example and add Javadoc documentation. Extract this comment documentation
 * into and HTML file using javadoc and view it with your web browser.
 */

//initialization/Overloading.java
// Demonstration of both constructor
// and ordinary method overloading

/**
 * create type Tree with two constructors and one info method
 * @author lh
 */
class Tree{
    int height;

    /**
     * No-argument constructor
     * assigns hight =0
     */
    public Tree() {
        System.out.println("Planting a seedling");
        height = 0;
    }

    /**
     * constructor taking an int argument,
     * assigns height that int  argument
     * @param height
     */
    public Tree(int height) {
        this.height = height;
        System.out.println("Creating new tree that is " + height + " feet tall");
    }

    /**
     * method to print height of tree object
     */
    void info(){
        System.out.println("Tree is " + height  + " feet tall" );
    }

    /**
     * overloaded method to print string argument
     * and height of a tree object
     * @param s
     */
    void info(String s){
        System.out.println(s +": Tree is " + height + " feet tall");
    }
}

/**
 * class to test construction of tree objects
 */
public class Overloading_ch2_16 {
    public static void main(String[] args){
        for(int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloading method");
        }
        new Tree();
    }
}
