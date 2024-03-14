package reuse;

/**
 * @author lh
 */
class Villain {
    private String name;

    protected void set(String name) {
        this.name = name;
    }

    Villain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}
public class Orc extends Villain{
    private int ocrNumber;

    public Orc(String name,int orcNumber) {
        super(name);
        this.ocrNumber = orcNumber;
    }

    public void change(String name,int orcNumber) {
        set(name);
        this.ocrNumber= orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + ocrNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger",12);
        System.out.println(orc);
        orc.change("Bob",19);
        System.out.println(orc);
    }
}
