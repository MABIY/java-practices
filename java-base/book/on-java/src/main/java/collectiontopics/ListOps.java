package collectiontopics;

import onjava.HTMLColors;

import java.util.*;

/**
 * @author lh
 */
public class ListOps {
    // Create a short list for testing:
    static final List<String> LIST = HTMLColors.LIST.subList(0,10);
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1,"x"); // Add at location 1
        a.add("x"); // Add at end
        // Add a collection:
        a.addAll(LIST);
        // add a collection starting at location 3:
        a.addAll(3,LIST);
        b = a.contains("1"); // Is it in there?
        // Is the entire collection in there?
        b = a.containsAll(LIST);
        // Lists allow random access, which is cheap
        // for ArrayList,expensive for linkedList
        s = a.get(1); // Get (typed) object at location 1
        i = a.indexOf("1"); //Tell index of object
        b = a.isEmpty(); // Any elements inside?
        it = a.iterator(); // Ordinary iterator
        lit =a.listIterator();// ListIterator
        lit =a.listIterator(3);// Start at location 3
        i = a.lastIndexOf("1"); // last match
        a.remove(1); // Remove location 1
        a.remove("3"); //Remove this object
        a.set(1,"y"); // Set location 1 to "y"
        // Keep everything that's in the argument
        // (the intersection of the two sets):
        a.retainAll(LIST);
        a.removeAll(LIST);
        i = a.size(); // How big is it?
        a.clear();// Remove all elements
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s= it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // Must move to an element after add();
        it.next();
        // remove the element after the new one:
        it.remove();
        // Must move to an element after remove();
        it.next();
        // Change the element after the deleted one:
        it.set("47");
    }
    public static void testVisual(List<String> a) {
        System.out.println(a);
        List<String> b = LIST;
        System.out.println("b = " + b);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);
        // Insert, remove, and replace elements
        // using a ListIterator;
        ListIterator<String> x = a.listIterator(a.size()/2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        // Traverse the list backwards:
        x = a.listIterator(a.size());
        while (x.hasPrevious()) System.out.println(x.previous() +" ");
        System.out.println();
        System.out.println("testVisual finished");
    }

    //There are some things that only linkedLists can do:
    public static void testLikedList() {
        LinkedList<String> ll = new LinkedList<>(LIST);
        System.out.println(ll);
        // Treat it like a stack, pushing:
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);
        // Like "peeking" at the top of a stack:
        System.out.println(ll.getFirst());
        // Like popping a stack:
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        // Treat it like a queue, pulling elements
        // off the tail end:
        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }


    public static void main(String[] args) {
        // Make and fill a new list each time:
        basicTest(new LinkedList<>(LIST));
        basicTest(new ArrayList<>(LIST));
        iterMotion(new LinkedList<>(LIST));
        iterMotion(new ArrayList<>(LIST));
        iterManipulation(new LinkedList<>(LIST));
        iterManipulation(new ArrayList<>(LIST));
        testVisual(new LinkedList<>(LIST));
        testLikedList();
    }
}
