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

        antTile = Tile.Digger;
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
    public void moveRandom() {
        Random rn = new Random();
        int direction = rn.nextInt(4) + 1;
        switch (direction) {
            case 1:
                setLocX(getLocX() - 1);
                if (antOutOfBounds()) {
                    setLocX(getLocX() + 1);
                    moveRandom();
                    break;
                }
                screen[getLocX() + 1][getLocY()] = Tile.T;
                screen[getLocX()][getLocY()] = getAntTile();
                break;

            case 2:
                setLocY(getLocY() + 1);
                if (antOutOfBounds()) {
                    setLocY(getLocY() - 1);
                    moveRandom();
                    break;
                }
                screen[getLocX()][getLocY() - 1] = Tile.T;
                screen[getLocX()][getLocY()] = getAntTile();
                break;

            case 3:
                setLocX(getLocX() + 1);
                if (antOutOfBounds()) {
                    setLocX(getLocX() - 1);
                    moveRandom();
                    break;
                }
                screen[getLocX() - 1][getLocY()] = Tile.T;
                screen[getLocX()][getLocY()] = getAntTile();
                break;

            case 4:
                setLocY(getLocY() - 1);
                if (antOutOfBounds()) {
                    setLocY(getLocY() + 1);
                    moveRandom();
                    break;
                }
                screen[getLocX()][getLocY() + 1] = Tile.T;
                screen[getLocX()][getLocY()] = getAntTile();
                break;

            default:
                break;
        }
    }

    public boolean antOutOfBounds() {
        if (getLocX() < 0 || getLocX() > 100) //Used to be 100
        {
            return true;
        }
        if (getLocY() < 0 || getLocY() > 100) {
            return true;
        }
        if (screen[getLocX()][getLocY()] == Tile.S)
            return true;
        else
            return false;
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
        antTile = Tile.Digger;
        return antTile;
    }


}
