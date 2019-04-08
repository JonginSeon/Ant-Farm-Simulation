package main;

public class AntType  {
    private Ant name;
    private static final long serialVersionUID = 1L;
    private Tile[][] screen;
    private int LocX;
    private int LocY;
    private int playSpeed;
    private Tile antTile;


    AntType(Tile antTile, int LocX, int LocY, int playSpeed,Tile[][] screen) {

    this.antTile=antTile;
    this.LocX = LocX;
    this.LocY = LocY;
    this.playSpeed = playSpeed;
    this.screen = screen;
    }
    public Tile getAntTile(){
        return antTile;
    }

    public void setAntTile() {
        this.antTile = antTile;
    }
    public int getLocX(){ return LocX;}
    public void setLocX(int LocX) {
        this.LocX = LocX;
    }
    public int getLocY(){ return LocY;}
    public void setLocY(int LocY){
        this.LocY = LocY;
    }
    public int getPlaySpeed(){ return LocX;}
    public void setPlaySpeed(int playSpeed){
        this.playSpeed = playSpeed;
    }

    public Tile[][] getScreenFromAL(){

        return screen;
    }
}
