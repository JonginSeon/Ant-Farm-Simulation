package main;

public class King implements Ant{
    private Tile antTile;
    private int LocX;
    private int LocY;

    public  King(int locX, int locY){
        antTile = Tile.K;
        LocX = locX;
        LocY = locY;
    }

    @Override
    public void setLocX(int locX) {
        LocX = locX;
    }

    @Override
    public void setLocY(int locY) {
        LocY = locY;
    }

    @Override
    public int getLocX() {
        return LocX;
    }

    @Override
    public int getLocY() { return LocY; }

    @Override
    public Tile getAntTile() {
        return antTile;
    }

}
