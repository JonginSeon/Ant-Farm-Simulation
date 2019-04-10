package main;

import java.util.Random;

public class DiggingAnt implements Ant {


    private Tile antTile;
    private int LocX;
    private int LocY;
    private  Tile[][] screen;
    private int playSpeed;
    AntFarm farm = new AntFarm();
   // Ant ant = new WorkingAnt();

    public  DiggingAnt(){

        antTile = Tile.G;
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
        antTile = Tile.G;
        return antTile;
    }


}
