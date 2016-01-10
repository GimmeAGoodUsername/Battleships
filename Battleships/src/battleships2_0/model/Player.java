package battleships2_0.model;


/**
 * The Class Player.
 *
 * @author Tim Gustaw 4691684 Gruppe 4b
 * @author Lukas Michaelis 4699916 Gruppe 4b
 * 13.12.2015
 * Player.java
 */
public class Player {
    
    /** The name. */
    private String name;
    
    /** The hit points. */
    private int hitPoints;
    
    /** The id. */
    private String id;
    
    /** The player hits. */
    private Arena playerHits;
    
    /** The player ships. */
    private Arena playerShips;

    /**
     * Instantiates a new player.
     *
     * @param name the name
     * @param hitPoints the hit points
     * @param id the id
     */
    public Player(String name, int hitPoints, String id) {
        super();
        this.name = name;
        this.hitPoints = hitPoints;
        this.id = id;
        //Someday the size of the grid is going to be determined by input as well.
        this.playerHits = new Arena(10, 10);
        this.playerShips = new Arena(10, 10);
        //this.playerHits.printTest();
        this.playerShips.testShips();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the hit points.
     *
     * @return the hit points
     */
    public int getHitPoints() {
        return this.hitPoints;
    }

    /**
     * Sets the hit points.
     *
     * @param hitPoints the new hit points
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

	/**
	 * Gets the player hits.
	 *
	 * @return the player hits
	 */
	public Arena getPlayerHits() {
		return playerHits;
	}

	/**
	 * Sets the player hits.
	 *
	 * @param playerHits the new player hits
	 */
	public void setPlayerHits(Arena playerHits) {
		this.playerHits = playerHits;
	}

	/**
	 * Gets the player ships.
	 *
	 * @return the player ships
	 */
	public Arena getPlayerShips() {
		return playerShips;
	}

	/**
	 * Sets the player ships.
	 *
	 * @param playerShips the new player ships
	 */
	public void setPlayerShips(Arena playerShips) {
		this.playerShips = playerShips;
	}
    
}
