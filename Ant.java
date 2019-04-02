package main;

public class Ant
{
    private Tile antTile;
    private int LocX;
    private int LocY;

    public Ant() {
        antTile = Tile.A;
        LocX = 10;
        LocY = 50;
    }

    public void setLocX(int locX) {
        LocX = locX;
    }

    public void setLocY(int locY) {
        LocY = locY;
    }

    public int getLocX() {
        return LocX;
    }

    public int getLocY() {
        return LocY;
    }

    public Tile getAntTile() {
        return antTile;
    }
}
