package annotations;

import onjava.atunit.Test;

/**
 * @author lh
 */
public class AUExternalTest extends AtUnitExample1{
    @Test
    boolean _MethodOne() {
        return methodOne().equals("This is methodOne");
    }
    @Test
    boolean _MethodTwo() {
        return methodTwo() == 2;
    }
}
