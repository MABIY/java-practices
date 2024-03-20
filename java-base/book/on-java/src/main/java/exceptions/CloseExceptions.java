package exceptions;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

/**
 * @author lh
 */
class CloseException extends Exception{
    public CloseException() {
    }

    public CloseException(String message) {
        super(message);
    }
}
class Reporter2 implements AutoCloseable {
    String name = getClass().getSimpleName();
    public Reporter2() {
        System.out.println("Creating " + name);
    }

    @Override
    public void close() throws CloseException {
        System.out.println("Closing " + name);
    }
}

class Closer  extends Reporter2 {
    @Override
    public void close() throws CloseException {
        super.close();
        throw new CloseException("close");
    }
}

class Closer1  extends Reporter2 {
    @Override
    public void close() throws CloseException {
        super.close();
        throw new CloseException("Closer1");
    }
}
public class CloseExceptions {
    public static void main(String[] args) {
        // one  header multiple exception
        try(
                First f = new First();
                Closer c = new Closer();
                Closer1 c1 = new Closer1();
                ) {
            System.out.println("In Body");
        } catch (CloseException e) {
            System.out.println("Caught: " + e);
        }
        // two header multiple exception and try body exception
        System.out.println("two: ----------");
        try(
                First f = new First();
                Closer c = new Closer();
                Closer1 c1 = new Closer1();
        ) {
            throw new RuntimeException();
        } catch (CloseException e) {
            System.out.println("Caught: " + e);
        } catch (Exception e){
            e.getSuppressed();
            System.out.println("Caught exception:" + e);
        }finally{
            System.out.println("p");
        }
    }
}
