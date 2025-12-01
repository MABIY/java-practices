package chapter2.content.javadoc;

import java.util.Date;

/**
 * The first Thinking in jav example program.
 * Displays a string and today's date.
 *
 * @author lh
 * @author lh@gmail.com
 * @version 4.0
 */
public class HelloDate {
    /**
     * Entry point to class and application.
     * @param args array of string arguments
     * @throws RuntimeException No other exceptions thrown
     */
    public static void main(String[] args){
        System.out.println("Hello, it's:");
        System.out.println(new Date());
    }
}
