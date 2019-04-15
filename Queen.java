package main;

public class Queen implements Ant {

    private Tile antTile;
    private int LocX;
    private int LocY;
    private int nestCenterX;
    private int nestCenterY;

    public Queen (){
        antTile = Tile.Q;
        LocX = 10;
        LocY = 50;
        nestCenterX = -1;
        nestCenterY = -1;
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
    public int getLocY() {
        return LocY;
    }

    public void setNestCenterX() {
        nestCenterX = LocX;
    }

    public int getNestCenterX() {
        return nestCenterX;
    }

    public void setNestCenterY() {
        nestCenterY = LocY;
    }

    public int getNestCenterY() {
        return nestCenterY;
    }

    @Override
    public Tile getAntTile() {
        return antTile;
    }

}
