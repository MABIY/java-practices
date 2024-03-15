package innerclasses;

/**
 * @author lh
 */
class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected final class PDestination implements Destination {
        public PDestination(String whereTo) {
            this.label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        private String label;
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
    }
}
