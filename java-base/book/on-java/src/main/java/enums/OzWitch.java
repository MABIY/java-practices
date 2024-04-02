package enums;

/**
 * @author lh
 */
public enum OzWitch {
    // Instances must be defined first , before methods:
    WEST("Miss Gulch, aka the Wicked Withc of the West"),
    NORTH("Glinda, the Goods Witch of the North"),
    EASt("Wicked witch of the East, wearer of the Ruby " +
            "Slippers, Crushed by Dorothy's house"),
    SOUTH("Goods by inference, but missing");
    private String description;

    // Constructor must be package or private access:

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
