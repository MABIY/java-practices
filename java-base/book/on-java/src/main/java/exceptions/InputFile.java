package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author lh
 */
public class InputFile {
    private BufferedReader in;

    public InputFile(String fname) throws FileNotFoundException {
        try{
            in = new BufferedReader(new FileReader(fname));
            // Other code that might throw exception
        } catch (FileNotFoundException e) {
            System.out.println("Could not open" + fname);
            throw  e;
        } catch (Exception e){
            // all other exceptions must close it
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        }finally {
            // Don't close it here!!
        }
    }

    public String getLine() {
        String s;
        try{
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readline() failed");
        }
        return s;
    }
}
