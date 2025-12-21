package chapter6;
/**
 * Demonstrates class access specifiers. Make a class
 * effectively private with private constructors.
 * @author lh
 */
class Soup1{
    private Soup1(){}

    public static Soup1 makeSoup(){
        return new Soup1();
    }
}

class Soup2{
    //(2) Create a static object and return a reference
    // upon request.(The "Singleton" Pattern):
    private static final Soup2 ps1 = new Soup2();
    private Soup2(){}

    public static Soup2 access(){
        return ps1;
    }

    public void f(){}
}
public class Lunch {
    void testPrivate(){
        // Can't do this! Private Constructor
        //! Soup1 soup =  new Soup1();
    }

    void testStatic(){
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleTon(){
        Soup2.access().f();
    }
}
