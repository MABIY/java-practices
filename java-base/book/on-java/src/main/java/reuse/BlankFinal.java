package reuse;

/**
 * @author lh
 */
class Poppet{
    private int i;

    public Poppet(int i) {
        this.i = i;
    }
}
public class BlankFinal {
    private final int i = 0;
    private final int j;
    private final Poppet p;

    public BlankFinal() {
        j = 1;
        p = new Poppet(1);
    }

    public BlankFinal(int j) {
        this.j = j;
        p = new Poppet(1);
    }
}
