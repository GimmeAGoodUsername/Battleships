package battleships2_0.model;

/**
 * The Enum ShipTypes.
 *
 * @author Tim Gustaw 4691684 Gruppe 4b
 * @author Lukas Michaelis 4699916 Gruppe 4b 13.12.2015 ShipTypes.java
 */
public enum ShipTypes {

    /** The Carrier. */
    Carrier(5, 1),
    /** The Battleship. */
    Battleship(4, 2),
    /** The Submarine. */
    Submarine(3, 3),
    /** The Destroyer. */
    Destroyer(2, 4),
    /** The Patrol. */
    Patrol(1, 1);

    /** The length. */
    private int length;

    /** The sum. */
    private int sum;

    /**
     * Instantiates a new ship types.
     *
     * @param length
     *            the length
     * @param sum
     *            the sum
     */
    ShipTypes(int length, int sum) {
        this.length = length;
        this.sum = sum;
    }

    /**
     * Gets the length.
     *
     * @return the length
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Gets the sum.
     *
     * @return the sum
     */
    public int getSum() {
        return this.sum;
    }
}
