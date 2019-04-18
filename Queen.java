package main;

/**
 * Every simulation begins with one Queen ant, and no more can be bought. The
 * Queen digs down to a depth of 70 tiles and creates a nest. From then on, it is
 * motionless, and other ants spawn around it when they are bought.
 */
public class Queen implements Ant {

    private Tile antTile;
    private int LocX;
    private int LocY;
    private int nestCenterX;
    private int nestCenterY;

    /**
     * Creates a Queen at tile (10, 50) and set the Tile Type to "Q".
     * Since the nest is not immediately created, its location is set
     * to (-1, -1) for now.
     */
    public Queen()
    {
        antTile = Tile.Q;
        LocX = 10;
        LocY = 50;
        nestCenterX = -1;
        nestCenterY = -1;
    }

    /**
     * Sets the X-coordinate for this ant
     * @param locX The new X-coordinate
     */
    @Override
    public void setLocX(int locX) {
        LocX = locX;
    }

    /**
     * Sets the Y-coordinate for this ant
     * @param locY The new Y-coordinate
     */
    @Override
    public void setLocY(int locY) {
        LocY = locY;
    }

    /**
     * Gets the X-coordinate for this ant
     * @return The X-coordinate
     */
    @Override
    public int getLocX() {
        return LocX;
    }

    /**
     * Gets the Y-coordinate for this ant
     * @return The Y-coordinate
     */
    @Override
    public int getLocY() {
        return LocY;
    }

    /**
     * Sets the horizontal position of the nest to the Queen's current X-coordinate.
     */
    public void setNestCenterX() {
        nestCenterX = LocX;
    }

    /**
     * Gets the X-coordinate for the nest.
     * @return The X-coordinate
     */
    public int getNestCenterX() {
        return nestCenterX;
    }

    /**
     * Sets the vertical position of the nest to the Queen's current Y-coordinate.
     */
    public void setNestCenterY() {
        nestCenterY = LocY;
    }

    /**
     * Gets the Y-coordinate for the nest.
     * @return The Y-coordinate
     */
    public int getNestCenterY() {
        return nestCenterY;
    }

    /**
     * Gets the Tile type for this ant
     * @return This ant's Tile type
     */
    @Override
    public Tile getAntTile() {
        return antTile;
    }

}
