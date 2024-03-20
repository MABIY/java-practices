package exceptions;

/**
 * @author lh
 */
class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}
abstract class Inning {
    public Inning() throws BaseballException{}
    public void event() throws BaseballException{}
    public abstract void atBat() throws Strike,Foul;
    public void walk(){}
}

class StormException extends Exception{}
class RainedOut extends StormException{}
class PopFoul extends Foul{}
interface Storm{
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}
public class StormyInning extends Inning implements Storm{

    // OK to add new exceptions for constructors,  but you
    // must deal with the base constructor exceptions:
    public StormyInning() throws RainedOut,BaseballException {
    }

    public StormyInning(String s) throws BaseballException {
    }

    @Override
    public void event()  {
    }

    @Override
    public void atBat() throws PopFoul{

    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args) {
        try{
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        // strike not thrown in derived version.
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Foul e) {
            throw new RuntimeException(e);
        } catch (Strike e) {
            throw new RuntimeException(e);
        } catch (RainedOut e) {
            throw new RuntimeException(e);
        } catch (BaseballException e) {
            throw new RuntimeException(e);
        }
    }
}
