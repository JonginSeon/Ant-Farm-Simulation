package main;

import java.util.Random;

public class WorkingAnt implements Ant{
    private Tile antTile;
    private int LocX;
    private int LocY;
    private  Tile[][] screen;
    AntFarm farm = new AntFarm();
    Ant digger = new DiggingAnt();
    private int playSpeed;

    //constructor
    public WorkingAnt (){
        antTile = Tile.W;
        LocX = 10;
        LocY = 50;
        screen = farm.getScreen();
        playSpeed =farm.getPlayspeed();

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
        antTile = Tile.W;
        return antTile;
    }

}

