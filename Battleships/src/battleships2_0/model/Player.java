package battleships2_0.model;


/**
 * The Class Player.
 *
 * @author Tim Gustaw 4691684 Gruppe 4b
 * @author Lukas Michaelis 4699916 Gruppe 4b
 * 13.12.2015
 * Player.java
 */
public class Player extends Arena{
    
    /** The name. */
    private String name;
    
    /** The hit points. */
    private int hitPoints;
    
    /** The id. */
    private String id;
    

    /**
     * Instantiates a new player.
     *
     * @param name the name
     * @param hitPoints the hit points
     * @param id the id
     */
    public Player(String name, int hitPoints, String id) {
        super(10,10);
        this.name = name;
        this.hitPoints = hitPoints;
        this.id = id;
        //Someday the size of the grid is going to be determined by input as well.
        
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

	
    public boolean isAlive(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j<10; j++){
                if(this.getGrid()[i][j]=='#')return true;
            }
        }
        return false;
    }
    
    public boolean takeHit(int row, int column){
        if(this.getGrid()[row][column]=='#'){
            this.setValue(row, column, 'X');
            return true;
        }else if(this.getGrid()[row][column]=='.'){
            this.setValue(row, column, 'O');
            return false;
        }
        return false;
    }
}
