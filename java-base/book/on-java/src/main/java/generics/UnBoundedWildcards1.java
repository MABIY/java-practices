package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lh
 */

public class UnBoundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends String> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
//        list3 = list;
    }
    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
//        list3 = list;
    }

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        assign3(new ArrayList());

        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        //Both forms are acceptable as List<?>:
        List<?> wildList = new ArrayList();
        wildList = new ArrayList<>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}
