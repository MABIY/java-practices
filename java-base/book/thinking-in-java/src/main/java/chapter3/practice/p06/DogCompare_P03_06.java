package chapter3.practice.p06;

import static util.Print.print;

/**
 * Create a class called Dog containing two Strings: name and says.
 * Following exercise 5, create a new Dog reference and assign it to spot's
 * object. Test for comparison using ==  and equals() for all references.
 * @author lh
 */

class Dog{
    String name;
    String says;

     void setName(String name) {
        this.name = name;
    }

     void setSays(String says) {
        this.says = says;
    }

    void showName(){
        print(name);
    }

    void speak(){
        print(says);
    }
}
public class DogCompare_P03_06 {
    public static void main(String[] args){
        Dog spot = new Dog();
        spot.setName("Spot");
        spot.setSays("Ruff!");
        Dog scruffy = new Dog();
        scruffy.setName("Scruffy");
        scruffy.setSays("Wurf!");
        spot.showName();
        spot.speak();
        scruffy.showName();
        scruffy.speak();
        Dog butch = new Dog();
        butch.setName("Butch");
        butch.setSays("Hello!");
        butch.showName();
        butch.speak();
        print("Comparison: ");
        print("spot == butch: " + (spot == butch));
        print("spot.equals(butch): " + spot.equals(butch));
        print("butch.equals(spot): " + butch.equals(spot));
        print("Now assign: spot = butch");
        spot = butch;
        print("spot == butch: " + (spot == butch));
        print("spot.equals(butch): " + spot.equals(butch));
        print("butch.equals(spot): " + butch.equals(spot));
        print("Sport:");
        spot.showName();
        spot.speak();
        print("Butch: ");
        butch.showName();
        butch.speak();
    }

}