package annotations;

import onjava.atunit.Test;

/**
 * @author lh
 */
public class StackLStringTst extends StackL<String>{
    @Test
    void tPush() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }

    @Test
    void tPop() {
        push("A");
        push("B");
        assert top().equals("B");
        assert top().equals("B");
    }
}
