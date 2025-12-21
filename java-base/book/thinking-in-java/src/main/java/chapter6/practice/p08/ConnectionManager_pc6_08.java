package chapter6.practice.p08;

import util.Range;

import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Following the form of the example Luch.java,create a class called
 * ConnectionManager that manages a fixed array of Connection objects.
 * The client programmer must be able to explicitly create Connection objects,
 * but can only get them via a static method in ConnectionManager. When ConnectionManager
 * runs out of objects, it returns a nul reference. Test the classes in main()
 * @author lh
 */
public class ConnectionManager_pc6_08 {
    private static class Connection{
        private static int count = 0;
        private int id = 0;

        private Connection(int id){
            System.out.println("invoke constructors constructor");
            this.id =id;
        }

        private static Connection makeConnection(){
            int id = count++;
            return new Connection(id);
        }

        public static int howMany(){
            return count;
        }

        @Override
        public String toString() {
            return ("Conneciton  " + count);
        }
    }

    private static final int CAPACITY = 3;
    private static int HOW_MANY_LEFT = CAPACITY;

    public static int getCapacity(){
        return HOW_MANY_LEFT;
    }
    static Connection[] connections;

    static {
        connections = Stream.generate(Connection::makeConnection).limit(CAPACITY).toArray(Connection[]::new);
    }

    public static Connection getConnection(){
        if(HOW_MANY_LEFT >0){
            return connections[--HOW_MANY_LEFT];
        }
        System.out.println("No more connections");
        return null;
    }

}
