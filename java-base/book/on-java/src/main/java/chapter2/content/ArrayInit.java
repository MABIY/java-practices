package chapter2.content;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * @author lh
 */
public class ArrayInit {
    public static void main(String[] args){
        Object[] objectArr = new Object[10];
        int[] intArr = new int[10];
        Assertions.assertNotNull(objectArr);
        for (Object object : objectArr) {
            Assertions.assertNull(object);
        }

        Assertions.assertNotNull(intArr);
        for (int intVal : intArr) {
            Assertions.assertEquals(0,intVal);
        }
    }
}
