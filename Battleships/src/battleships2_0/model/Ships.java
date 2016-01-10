package battleships2_0.model;

/**
 * The Class Ships.
 *
 * @author Tim Gustaw 4691684 Gruppe 4b
 * @author Lukas Michaelis 4699916 Gruppe 4b 13.12.2015 Ships.java
 */
public class Ships {

    /** The type. */
    private ShipTypes type;

    /**
     * Instantiates a new ships.
     *
     * @param type
     *            the type
     */
    public Ships(ShipTypes type) {
        this.type = type;
    }

    /**
     * Prints the type.
     */
    public void printType() {
        System.out.println(this.type.getLength());
    }
}
