package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author lh
 */
public class SimpleRead {

    public static BufferedReader input =
            new BufferedReader(new StringReader(
                    "Sir Robin of Camelot\n22 1.61803"));

    public static void main(String[] args) {
        try {
            System.out.println("What is your name?");
            String name = input.readLine();
            System.out.println(name);
            System.out.println("How old are you? " +
                    "Wht is you favorite double?");
            String numbers = input.readLine();
            System.out.println(numbers);
            String[] numArray = numbers.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.printf("Hi %s.%n",name);
            System.out.printf("In 5 years you will be %d.%n",age+5);
            System.out.printf("My favorite double is %f",favorite/2);
        } catch (IOException e) {
            System.out.println("I/O exception");
        }
    }
}
