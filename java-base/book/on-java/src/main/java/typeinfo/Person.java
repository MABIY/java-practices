package typeinfo;

import java.util.Optional;

/**
 * @author lh
 */
public class Person {
    public final Optional<String> first;
    public final Optional<String> last;
    public final Optional<String> address;
    //etc
    public final Boolean empty;

    public Person(String first, String last, String address) {
        this.first = Optional.ofNullable(first);
        this.last = Optional.ofNullable(last);
        this.address = Optional.ofNullable(address);
        empty = !this.first.isPresent()
                && !this.last.isPresent()
                && !this.address.isPresent();
    }

    public Person(String first,String last) {
        this(first,last,null);
    }
    public Person(String last) {
        this(null,last,null);
    }

    public Person() {
        this(null,null,null);
    }

    @Override
    public String toString() {
        if(empty) {
            return "<Empty>";
        }
        return (first.orElse("" )+ " " + last.orElse("") + " " + address.orElse("")).trim();
    }

    public static void main(String[] args) {
        System.out.println(new Person());
        System.out.println(new Person("Simith"));
        System.out.println(new Person("Bob","Smith"));
        System.out.println(new Person("Bob","Smith","11 Degree Lane, Frostbite Falls,MN"));
    }
}
