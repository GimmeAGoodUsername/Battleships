package battleships2_0.model;

/**
 * The Enum AlphabeticValue.
 *
 * @author Tim Gustaw 4691684 Gruppe 4b
 * @author Lukas Michaelis 4699916 Gruppe 4b 13.12.2015 AlphabeticValue.java
 */
public enum AlphabeticValue {

    /** The a. */
    A(0),
    /** The b. */
    B(1),
    /** The c. */
    C(2),
    /** The d. */
    D(3),
    /** The e. */
    E(4),
    /** The f. */
    F(5),
    /** The g. */
    G(6),
    /** The h. */
    H(7),
    /** The i. */
    I(8),
    /** The j. */
    J(9),
    /** The k. */
    K(10),
    /** The l. */
    L(11),
    /** The m. */
    M(12),
    /** The n. */
    N(13),
    /** The o. */
    O(14),
    /** The p. */
    P(15),
    /** The q. */
    Q(16),
    /** The r. */
    R(17),
    /** The s. */
    S(18),
    /** The t. */
    T(19),
    /** The u. */
    U(20),
    /** The v. */
    V(21),
    /** The w. */
    W(22),
    /** The x. */
    X(23),
    /** The y. */
    Y(24),
    /** The z. */
    Z(25);

    /** The value. */
    private int value;

    /**
     * Instantiates a new alphabetic value.
     *
     * @param v
     *            the v
     */
    AlphabeticValue(int v) {
        this.value = v;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }

}
