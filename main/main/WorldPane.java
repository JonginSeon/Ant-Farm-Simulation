package main;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

import java.util.Timer;
import java.util.TimerTask;

public class WorldPane extends AnchorPane {

    private Label[][] world;
    private AntFarm farm;
    int numberOfAnts = 0;
    private Ant[] ants = new Ant[10];
    private Ant queen = new Queen();


    private Timer time;

    public WorldPane() {

        farm = new AntFarm();



        TilePane tilePane = new TilePane();

        tilePane.setPrefTileHeight(10.0);

        tilePane.setPrefTileWidth(10.0);
        tilePane.setHgap(0.0);

        tilePane.setVgap(0.0);

        tilePane.setTileAlignment(Pos.TOP_LEFT);

        createWorld(tilePane);

        setTopAnchor(tilePane, 0.0);

        setBottomAnchor(tilePane, 0.0);

        setRightAnchor(tilePane, 0.0);

        setLeftAnchor(tilePane, 0.0);

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
                //only sky
                if (screen[r][c] == Tile.S)
                    this.world[r][c].setStyle("-fx-background-color: DeepSkyBlue");

                //only dirt
                else if (screen[r][c] == Tile.D)
                    this.world[r][c].setStyle("-fx-background-color: Peru");


                //only tile
                else if (screen[r][c] == Tile.T)
                    this.world[r][c].setStyle("-fx-background-color: Black");

                else if (screen[r][c] == Tile.Q)
                    this.world[r][c].setStyle("-fx-background-color: Pink");

                else if (screen[r][c] == Tile.G)
                    this.world[r][c].setStyle("-fx-background-color: Yellow");

                else if (screen[r][c] == Tile.W)
                    this.world[r][c].setStyle("-fx-background-color: Red");

                else if (screen[r][c] == Tile.F)
                    this.world[r][c].setStyle("-fx-background-color: purple");
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
                            antBehavior.moveRandom(ants[i], farm.getScreen());
                            break;

                        case W:
                            antBehavior.moveRandomCross(ants[i], farm.getScreen());
                            break;

                        case G:
                            antBehavior.moveRandomDiag(ants[i], farm.getScreen());
                            break;

                    }
                }



                updateWorld(farm.getScreen());
            }
        };
            time.schedule(task, 0, farm.getPlayspeed());
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