package interfaces.music4;

import mucis.Note;

/**
 * @author lh
 */
interface InstrumentT {
    int VALUE = 5;
    public void f();
    default  void play(Note n) {
        System.out.println(this + ".play()" + n);
        f();
    }

    void test();
}


public class Music5 {
}
