package generics;

import onjava.Amphibian;
import onjava.Tuple4;
import onjava.Vehicle;

import java.util.ArrayList;

/**
 * @author lh
 */
public class TupleList<A,B,C,D> extends ArrayList<Tuple4<A,B,C,D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian,String,Integer> t1 = new TupleList<>();
        t1.add(TupleTest2.h());
        t1.add(TupleTest2.h());
        t1.forEach(System.out::println);
    }
}
