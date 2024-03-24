package typeinfo;

import java.util.ArrayList;

/**
 * @author lh
 */
public class Staff extends ArrayList<Position> {
    public Staff(String... titles) {
        add(titles);
    }

    public static void main(String[] args) {

        Staff staff = new Staff(
                "President",
                "CTO",
                "Marketing Manager",
                "Product Manager",
                "Project Lead",
                "Software Engineer",
                "Software Engineer",
                "Software Engineer",
                "Software Engineer",
                "Test Engineer",
                "Technical Writer");
        staff.fillPostion("President", new Person("Me", "Last", "The Top Lonely At"));
        staff.fillPostion("Project Lead", new Person("Janet", "Planner", "The Burbs"));

        if (staff.positionAvailable("Software Engineer"))
            staff.fillPostion("Software Engineer", new Person("Bob", "Coder", "Bright Light City"));

        System.out.println(staff);
    }

    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String... titles) {
        for (String title : titles) {
            add(new Position(title));
        }
    }

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPerson().empty) {
                return true;
            }
        }
        return false;
    }

    public void fillPostion(String title, Person hire) {
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPerson().empty) {
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position " + title + " not available");
    }
}
