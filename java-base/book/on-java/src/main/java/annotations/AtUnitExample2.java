package annotations;

import onjava.atunit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author lh
 */
public class AtUnitExample2 {
    public String methodOne(){
        return "This is methodOne";
    }

    public int methodTwo(){
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    void assertExample() {
        assert methodOne().equals("This is methodOne");
    }

    @Test
    void  assertFailureExample() {
        assert  1 == 2: "What is surprise!";
    }

    @Test
    void exceptionExample() throws IOException {
        try(FileInputStream fis = new FileInputStream("nofile.text")){

        }
    }

    @Test
    boolean assertAndReturn() {
        // Assertion with message:
        assert methodTwo() == 2: "methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }
}
