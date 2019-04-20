package main;

/**
 * The King costs 10 food to purchase and can move in one space
 * in any direction, diagonally or straight.
 */
public class King implements Ant {

    /**
     * The Tile type that corresponds to this Ant.
     */
    private Tile antTile;

    /**
     * The location on the X axis.
     */
    private int locX;

    /**
     * The location on the Y axis.
     */
    private int locY;

    /**
     * Creates a King with the given X and Y coordinates and the Tile Type "K".
     *
     * @param locX This ant's X coordinate in the 100 x 100 world
     * @param locY This ant's Y coordinate in the 100 x 100 world
     */
    public King(int locX, int locY) {
        antTile = Tile.K;
        this.locX = locX;
        this.locY = locY;
    }

    /**
     * Sets the X-coordinate for this ant.
     *
     * @param locX The new X-coordinate
     */
    @Override
    public void setLocX(int locX) {
        this.locX = locX;
    }

    /**
     * Sets the Y-coordinate for this ant.
     *
     * @param locY The new Y-coordinate
     */
    @Override
    public void setLocY(int locY) {
        this.locY = locY;
    }

    /**
     * Gets the X-coordinate for this ant.
     *
     * @return The X-coordinate
     */
    @Override
    public int getLocX() {
        return locX;
    }

    /**
     * Gets the Y-coordinate for this ant.
     *
     * @return The Y-coordinate
     */
    @Override
    public int getLocY() {
        return locY;
    }

    /**
     * Gets the Tile type for this ant.
     *
     * @return This ant's Tile type
     */
    @Override
    public Tile getAntTile() {
        return antTile;
    }
}
