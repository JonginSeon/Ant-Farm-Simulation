package main;

import java.util.Random;

public class Queen implements Ant {

    private Tile antTile;
    private int LocX;
    private int LocY;
    private  Tile[][] screen;
    private int playSpeed;
    AntFarm farm = new AntFarm();

    //constructor
    public Queen (){
        antTile = Tile.Q;
        LocX = 10;
        LocY = 50;
        screen = farm.getScreen();
        playSpeed=farm.getPlayspeed();

    }

    @Override
    public Tile[][] getScreen(){
        return screen;
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

    @Override
    public Tile getAntTile() {
        antTile = Tile.Q;
        return antTile;
    }

}
