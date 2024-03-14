package reuse;

/**
 * @author lh
 */
class Homer {
    char doh(char c ) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(flaot)");
        return 1.0f;
    }

    void doh(Milhouse m){
        System.out.println("super milhouse");
    }
}

class Milhouse {

}
class Bart extends Homer {
    @Override
    void doh(Milhouse m) {
        System.out.println("sub Milhouse");
    }
}
public class HIde {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
        Homer h = new Homer();
        h.doh(new Milhouse());
    }
}
