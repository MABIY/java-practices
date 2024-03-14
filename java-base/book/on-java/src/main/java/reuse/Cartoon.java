package reuse;

/**
 * @author lh
 */

class Art{
    public Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing constructor");
    }
}
public class Cartoon extends Drawing{


    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
