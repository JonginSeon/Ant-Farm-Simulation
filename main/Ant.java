package main;

public interface Ant
{

    void moveRandom();
    void setLocX(int locX);
    void setLocY(int locY);
    int getLocX();
    int getLocY();
    Tile getAntTile();
    boolean antOutOfBounds();
    Tile[][] getScreen();


}
