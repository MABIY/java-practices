package collectiontopics;


import java.util.PriorityQueue;

/**
 * @author lh
 */
class ToDoItem implements Comparable<ToDoItem> {
    private char primary;
    private int secondary;
    private String item;

    public ToDoItem(String item, char primary, int secondary) {
        this.primary = primary;
        this.secondary = secondary;
        this.item = item;
    }

    @Override
    public int compareTo(ToDoItem arg) {
        if (primary > arg.primary) return 1;
        if (primary == arg.primary)
            if (secondary > arg.secondary) return 1;
            else if (secondary == arg.secondary) return 0;
        return -1;
    }

    @Override
    public String toString() {
        return Character.toString(primary) + secondary +": "+ item;
    }
}

public class ToDoList {
    public static void main(String[] args){
        PriorityQueue<ToDoItem> toDo = new PriorityQueue<>();
        toDo.add(new ToDoItem("Emtpty trash",'C',4));
        toDo.add(new ToDoItem("Feed dog",'A',4));
        toDo.add(new ToDoItem("Feed bird",'B',7));
        toDo.add(new ToDoItem("Mow lawn",'C',3));
        toDo.add(new ToDoItem("Water lawn",'A',1));
        toDo.add(new ToDoItem("Feed cat",'B',1));
        while (!toDo.isEmpty()) {
            System.out.println(toDo.remove());
        }
    }
}
