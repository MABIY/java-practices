package reuse;

/**
 * @author lh
 */
public class DerivedSpaceShipControls extends SpaceShipControls {
    private String name;

    public DerivedSpaceShipControls(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        DerivedSpaceShipControls protector = new DerivedSpaceShipControls("NSEA Protector");
        protector.forward(100);
    }
}
