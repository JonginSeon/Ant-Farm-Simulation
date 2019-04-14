package main;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class creates and updates an array of multi-colored labels
 * by analyzing the Tile array from an AntFarm object.
 * @author Elijah, Jongin, Justin
 * @version 4/12/2019
 */
public class WorldPane extends AnchorPane {

    private Label[][] world;
    private AntFarm farm;
    int numberOfAnts = 0;
    private Ant[] ants = new Ant[10];
    private int foodObtained=0;

    private Ant queen = new Queen();
    private String[] split;
    private SimpleStringProperty sspTime;
    private SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S");

    private long timer;
   private int count=0;
    private Timer time;

    public WorldPane() {
        sspTime = new SimpleStringProperty("00:00:00");
        farm = new AntFarm();

        TilePane tilePane = new TilePane();

        tilePane.setPrefTileHeight(9.0);
        tilePane.setPrefTileWidth(9.0);
        tilePane.setHgap(0.0);
        tilePane.setVgap(0.0);
        tilePane.setTileAlignment(Pos.TOP_LEFT);

        createWorld(tilePane);

        setTopAnchor(tilePane, 0.0);
        setBottomAnchor(tilePane, 0.0);
        setRightAnchor(tilePane, 0.0);
        setLeftAnchor(tilePane, 0.0);

        setMaxSize(900, 945);
        setMinSize(900, 945);

        getChildren().add(tilePane);

    }

    public AntFarm getFarm() {
        return this.farm;
    }

    public void createWorld(TilePane tilePane) {

        ants[0] = queen;
        numberOfAnts += 1;

        Label label;
        this.world = new Label[100][100];

        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                label= new Label();
                label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                if (r <= 10) {
                    label.setStyle("-fx-background-color: DeepSkyBlue");
                } else {
                    label.setStyle("-fx-background-color: Peru");
                }

                tilePane.getChildren().add(label);
                this.world[r][c] = label;
            }
        }
    }

    public void updateWorld(Tile[][] screen)
    {
        for (int r = 0; r < 100; r++) {

            for (int c = 0; c < 100; c++) {

                //if(screem[r][c] )

                //only sky
                if (screen[r][c] == Tile.S)
                    this.world[r][c].setStyle("-fx-background-color: DeepSkyBlue");

                //only dirt
                else if (screen[r][c] == Tile.D)
                    this.world[r][c].setStyle("-fx-background-color: Peru");


                //only tile
                else if (screen[r][c] == Tile.T)
                    this.world[r][c].setStyle("-fx-background-color: SaddleBrown");
                else if (screen[r][c] == Tile.Q)
                    this.world[r][c].setStyle("-fx-background-color: Pink");
                else if (screen[r][c] == Tile.G)
                    this.world[r][c].setStyle("-fx-background-color: Yellow");
                else if (screen[r][c] == Tile.W)
                    this.world[r][c].setStyle("-fx-background-color: Red");
                else if (screen[r][c] == Tile.F)
                    this.world[r][c].setStyle("-fx-background-color: Green");
            }
        }
    }

    public void resetWorld()
    {
        this.farm = new AntFarm();
        updateWorld(farm.getScreen());

        this.ants = new Ant[10];
        this.numberOfAnts = 0;
        this.queen = new Queen();
        ants[0] = queen;
        numberOfAnts += 1;
        updateWorld(farm.getScreen());
    }

    public int getFoodObtained(){

        return foodObtained;

    }
    public void setFoodObtained(int foodObtained){

        this.foodObtained = foodObtained;
    }



       public void runSimulation()
    {
        time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Behavior antBehavior = new Behavior();
                Tile currentAnt;
                for (int i = 0; i < numberOfAnts; i++) {
                    currentAnt = ants[i].getAntTile();
                    switch(currentAnt) {

                        case Q:
                            antBehavior.digToBottom((Queen) ants[i], farm.getScreen());

                            break;

                        case W:
                            antBehavior.moveRandom(ants[i], farm.getScreen());
                            break;

                        case G:
                            antBehavior.moveRandomCross(ants[i], farm.getScreen());
                            break;

                    }
                }
                if(antBehavior.getFoodObtained()==1){

                    foodObtained++;
                    System.out.println(foodObtained);
                }

                count = count+1;
                if(count%5 ==0) {

                antBehavior.foodGenerator(farm.getScreen());
                }
                updateTime();
                updateWorld(farm.getScreen());
            }
        };
            time.schedule(task, 0, farm.getPlayspeed());
    }

    public synchronized void updateTime() {
        this.timer = this.timer + 10;
        split = sdf.format(new Date(this.timer)).split(":");
        sspTime.set(split[0] + ":" + split[1] + ":" + (split[2].length() == 1 ? "0" + split[2] : split[2].substring(0, 2)));
    }

    public synchronized long getTime() {
        return timer;
    }

    public synchronized SimpleStringProperty getSspTime() {
        return sspTime;
    }

    public void update(){
        updateWorld(farm.getScreen());
    }

    public Ant[] getAnts() {
        return ants;
    }

    public int getNumberOfAnts() {
        return numberOfAnts;
    }

    public void setNumberOfAnts(int numberOfAnts) {
        this.numberOfAnts = numberOfAnts;
    }

    public void stopSimulation()
    {
        time.cancel();
    }


}