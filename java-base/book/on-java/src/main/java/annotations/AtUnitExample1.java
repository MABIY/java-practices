package annotations;

import onjava.atunit.Test;

/**
 * @author lh
 */
public class AtUnitExample1 {
    public String methodOne(){
        return "This is methodOne";
    }

    public int methodTwo(){
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2() {
        return methodTwo() == 2;
    }

    @Test
    private boolean m3() {
        return true;
    }
    // Shows output for failure:
    @Test
    boolean failureTest() {
        return false;
    }
    @Test
    boolean anotherDisappointment() {
        return false;
    }
}
