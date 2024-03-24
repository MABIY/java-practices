package onjava;

/**
 * @author lh
 */
public class Tuple4<A,B,C,D> extends Tuple3<A,B,C>{
    public final  D a4;
    public Tuple4(A a1, B a2, C c ,D d) {
        super(a1, a2, c);
        a4 = d;
    }

    @Override
    public String rep() {
        return super.rep() +", " + a4;
    }
}
