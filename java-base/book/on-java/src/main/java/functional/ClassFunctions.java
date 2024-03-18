package functional;

import java.util.Comparator;
import java.util.function.*;

/**
 * @author lh
 */
class AA{}
class BB{}
class CC{}

public class ClassFunctions {
    static AA f1() {
        return new AA();
    }
    static int f2(AA aa1,AA aa2){
        return 1;
    }

    static void f3(AA aa){}
    static void f4(AA aa,BB bb) {}

    static CC f5(AA aa){return new CC();}
    static CC f6(AA aa,BB bb){
        return new CC();
    }
    static boolean f7(AA aa){return true;};
    static boolean f8(AA aa,BB bb) {return true;}
    static AA f9(AA aa) {return new AA();}
    static AA f10(AA aa1,AA aa2) {return new AA();}

    public static void main(String[] args){
        Supplier<AA> s = ClassFunctions::f1;
        s.get();
        Comparator<AA> c = ClassFunctions::f2;
        c.compare(new AA(),new AA());
        Consumer<AA> cons = ClassFunctions::f3;
        cons.accept(new AA());
        BiConsumer<AA,BB> bicons = ClassFunctions::f4;
        bicons.accept(new AA(),new BB());
        Function<AA,CC> f = ClassFunctions::f5;
        CC cc = f.apply(new AA());
        BiFunction<AA,BB,CC> bif = ClassFunctions::f6;
        cc = bif.apply(new AA(),new BB());
        Predicate<AA> p = ClassFunctions::f7;
        boolean result = p.test(new AA());
        BiPredicate<AA,BB> bip = ClassFunctions::f8;
        result = bip.test(new AA(),new BB());
        UnaryOperator<AA> uo = ClassFunctions::f9;
        AA aa = uo.apply(new AA());
        BinaryOperator<AA> bo = ClassFunctions::f10;
        aa = bo.apply(new AA(),new AA());
    }
}
