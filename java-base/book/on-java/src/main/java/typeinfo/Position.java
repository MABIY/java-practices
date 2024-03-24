package typeinfo;

import java.util.Optional;

/**
 * @author lh
 */

class EmptyTitleException extends RuntimeException{}
public class Position {
    private String title;
    private Person person;

    public Position(String title, Person person) {
        setTitle(title);
        setPerson(person);
    }

    Position(String jobTitle) {
        this(jobTitle,null );
    }

    public static void main(String[] args){
        System.out.println(new Position("CEO"));
        System.out.println(new Position("Programmer",
                new Person("Arthur","Fonzarelli")));

        try {
            new Position(null);
        } catch (Exception e) {
            System.out.println("caught " + e);
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        // uses empty Person if newPerson is null:
        this.person = Optional.ofNullable(person).orElse(new Person());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        // throws EmptyTitleException if newTitle is null:
        this.title = Optional.ofNullable(title).orElseThrow(EmptyTitleException::new);
    }

    @Override
    public String toString() {
        return "Position: " +title + ", Employee: " + person;
    }

}
