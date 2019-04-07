package main;

/**
 * This class stores the location of an Ant tile for use in WorldPane and AntFarm
 * @author Justin
 * @version 4/06/2019
 */
public class Ant
{
    private Tile antTile; /** The tile type the this ant corresponds to */
    private int LocX; /** The location of this ant on the X axis */
    private int LocY; /** The location of this ant on the Y axis */

    /**
     * The standard constructor. It sets an Ant's Tile type to 'A', its
     * x-location to 10, and its y-location to 50.
     */
    public Ant() {
        antTile = Tile.A;
        LocX = 10;
        LocY = 50;
    }

    /**
     * This method changes the Ant's internal x-coordinate.
     * @param locX The new location for the Ant
     */
    public void setLocX(int locX) {
        LocX = locX;
    }

    /**
     * This method changes the Ant's internal y-coordinate.
     * @param locY The new location for the Ant
     */
    public void setLocY(int locY) {
        LocY = locY;
    }

    /**
     * @return LocX
     */
    public int getLocX() {
        return LocX;
    }

    /**
     * @return LocY
     */
    public int getLocY() {
        return LocY;
    }

    /**
     * @return antTile
     */
    public Tile getAntTile() {
        return antTile;
    }

}