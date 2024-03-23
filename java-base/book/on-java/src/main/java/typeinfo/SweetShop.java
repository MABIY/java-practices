package typeinfo;

/**
 * @author lh
 */
class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Candy {
    static {
        System.out.println("Loading Gandy");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }

        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
