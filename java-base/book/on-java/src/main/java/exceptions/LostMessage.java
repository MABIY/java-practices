package exceptions;

import javax.print.attribute.standard.PagesPerMinute;

/**
 * @author lh
 */
class VeryImportException extends Exception{
    @Override
    public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}
public class LostMessage {
    void f() throws VeryImportException {
        throw new VeryImportException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try{
            LostMessage lm = new LostMessage();
            try{
                lm.f();
            } finally{
                lm.dispose();
            }
        }catch (VeryImportException | HoHumException e){
            System.out.println(e);
        }
    }
}
