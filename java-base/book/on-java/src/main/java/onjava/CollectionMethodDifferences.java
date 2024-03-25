package onjava;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lh
 */
public class CollectionMethodDifferences {
    static Set<String> methodSet(Class<?>  type) {
        return Arrays.stream(type.getMethods())
                .map(Method::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    static void interfaces(Class<?> type) {
        System.out.println("Interfaces in " + type.getSimpleName() +": ");
        System.out.println(
                Arrays.stream(type.getInterfaces()).map(Class::getSimpleName).collect(Collectors.toList()));
    }

    static Set<String> object = methodSet(Object.class);
    static {
        object.add("clone");
    }

    static void difference(Class<?> subSet,Class<?> superSet) {
        System.out.println(subSet.getSimpleName() +
                " extends " + superSet.getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(subSet),methodSet(superSet));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(subSet);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class,Collection.class);
        difference(HashSet.class,Set.class);
        difference(LinkedHashSet.class,HashSet.class);
        difference(TreeSet.class,Set.class);
        difference(List.class,Collection.class);
        difference(ArrayList.class, List.class);
        difference(Queue.class,Collection.class);
        difference(PriorityQueue.class,Queue.class);
        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class,Map.class);
        difference(LinkedHashMap.class,HashMap.class);
        difference(SortedMap.class,Map.class);
        difference(TreeMap.class,Map.class);
    }
}
