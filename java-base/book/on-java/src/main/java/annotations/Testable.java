package annotations;

import onjava.atunit.Test;

/**
 * @author lh
 */
public class Testable {
    public void execute(){
        System.out.println("Executing..");
    }
    @Test
    void testExecute() {
        execute();
    }
}
