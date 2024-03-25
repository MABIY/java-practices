package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 */
public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static <T> T readExact(List<T> list ) {
        return list.get(0);
    }

    // A static method adapts to each calll:
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        f =readExact(apples);
    }

    //A class type is established
    // when the class is instantiated:
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruits);
//        Fruit a = fruitReader.readExact(apples);
        // errors: incompatible types: List<Apple>
        // canot be converted to List<Fruit>
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }

    }

    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruits);
        Fruit a = fruitReader.readCovariant(apples);
    }
    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
