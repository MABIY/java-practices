package chapter3.practice.p05;

import static util.Print.print;

/**
 * Create a class called Dog containing two Strings: name and says.
 * In main(), create two dog objects with  name "spot" (who says "Ruff!") and
 * "scruffy" (who says "Wurf!"). Then display their names and what they say.
 * @author lh
 */
class Dog {
    String name;
    String says;

    void setName(String name) {
        this.name = name;
    }

    void setSays(String says) {
        this.says = says;
    }

    void showName() {
        print(name);
    }

    void speak() {
        print(says);
    }
}

public class DogTest_P03_05 {
    public static void main(String[] args){
        Dog spot = new Dog();
        spot.setName("Sport");
        spot.setSays("Ruff!");
        Dog scruffy = new Dog();
        scruffy.setName("Scruffy");
        scruffy.setSays("Wurf!");
        spot.showName();
        spot.speak();
        scruffy.showName();
        scruffy.speak();
    }
}
