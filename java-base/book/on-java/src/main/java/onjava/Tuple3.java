package onjava;

/**
 * @author lh
 */
public class Tuple3<A,B,C> extends Tuple2<A,B>{
    public final C a3;
    public Tuple3(A a1, B a2, C c) {
        super(a1, a2);
        a3 =c;
    }

    @Override
    public String rep() {
        return super.rep() +", " + a3;
    }
}
