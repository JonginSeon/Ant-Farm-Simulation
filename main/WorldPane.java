package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;


import java.util.Timer;
import java.util.TimerTask;

public class WorldPane extends AnchorPane {

    private Label[][] world;
    private Cell[][] temp;
    private AntFarm farm;
    int numberOfAnts = 0;
    private Ant[] ants = new Ant[10];
    private Ant queen = new Queen();


    private Timer time;

    public WorldPane() {

        farm = new AntFarm();

        ButtonHandler handler = new ButtonHandler();

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
        //createDefaultSkin();
     //  getStyleClass().setAll("my-custom-control");


    }

    public AntFarm getFarm() {
        return this.farm;
    }

    public void createWorld(TilePane tilePane) {

        ants[0] = queen;
        numberOfAnts += 1;

        Button btn;
        Label btn1;
        this.world = new Label[100][100];


        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {

               // btn = new Button();
                btn1= new Label();
                btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                //btn.setMinSize(setMaxWidth();,70);
                if (r <= 10) {
                    btn1.setStyle("-fx-background-color: DeepSkyBlue");

                } else {

                    btn1.setStyle("-fx-background-color: Peru");

                }

                //btn.setOnAction(handler);

                tilePane.getChildren().add(btn1);

                this.world[r][c] = btn1;

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
            }
        }
    }

    public void resetWorld()
    {
        this.farm = new AntFarm();
        updateWorld(farm.getScreen());
        //updateWorld(farm.getScreen(),farm.getScreen());
        this.ants = new Ant[10];
        this.numberOfAnts = 0;
        this.queen = new Queen();
        ants[0] = queen;
        numberOfAnts += 1;
        updateWorld(farm.getScreen());
        //updateWorld(digger.getScreen(),worker.getScreen());

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
                //updateWorld(digger.getScreen(),worker.getScreen());
            }
        };
            time.schedule(task, 0, farm.getPlayspeed());

    }

    public void update(){
        updateWorld(farm.getScreen());
        //updateWorld(digger.getScreen(),worker.getScreen());
       // updateWorld(farm.get(0).getScreenFromAL(),farm.get(1).getScreenFromAL());

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

    public class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            for (int r = 0; r < 100; r++) {
                for (int c = 0; c < 100; c++) {
                    if (world[r][c] == event.getSource()) {
                        world[r][c].setStyle("-fx-background-color: Black");
                    }
                }
            }
        }
    }


}