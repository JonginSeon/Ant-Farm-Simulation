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
    private Ant digger = new DiggingAnt();
    private Ant worker = new WorkingAnt();
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

    public void updateWorld(Tile[][] tile1,Tile[][] tile2,Tile[][] tile3)
    {

        for (int r = 0; r < 100; r++) {

            for (int c = 0; c < 100; c++) {
                //only sky
                if (tile1[r][c] == Tile.S && tile2[r][c] == Tile.S && tile3[r][c] == Tile.S)
                    this.world[r][c].setStyle("-fx-background-color: DeepSkyBlue");
                //only dirt
                else if (tile1[r][c] == Tile.D && tile2[r][c] == Tile.D && tile3[r][c] == Tile.D)
                    this.world[r][c].setStyle("-fx-background-color: Peru");


                //only tile
                else if (tile1[r][c] == Tile.T && tile2[r][c] == Tile.T && tile3[r][c] == Tile.T)
                    this.world[r][c].setStyle("-fx-background-color: Black");



                //tile vs dirt   t = 0 D = 1
                else if (tile1[r][c] == Tile.T && tile2[r][c] == Tile.T && tile3[r][c] == Tile.D) this.world[r][c].setStyle("-fx-background-color: Black");
                else if (tile1[r][c] == Tile.T && tile2[r][c] == Tile.D && tile3[r][c] == Tile.D) this.world[r][c].setStyle("-fx-background-color: Black");
                else if (tile1[r][c] == Tile.T && tile2[r][c] == Tile.D && tile3[r][c] == Tile.T) this.world[r][c].setStyle("-fx-background-color: Black");
                else if (tile1[r][c] == Tile.D && tile2[r][c] == Tile.T && tile3[r][c] == Tile.T) this.world[r][c].setStyle("-fx-background-color: Black");
                else if (tile1[r][c] == Tile.D && tile2[r][c] == Tile.T && tile3[r][c] == Tile.D) this.world[r][c].setStyle("-fx-background-color: Black");
                else if (tile1[r][c] == Tile.D && tile2[r][c] == Tile.D && tile3[r][c] == Tile.T) this.world[r][c].setStyle("-fx-background-color: Black");


                //tile1 = yellow ,digger
                //tile2 = red, worker
                //tile3 = pink, Queen

                else if (tile1[r][c] == Tile.G && tile2[r][c] == Tile.T && tile3[r][c] == Tile.T)this.world[r][c].setStyle("-fx-background-color: Yellow");
                else if (tile1[r][c] == Tile.G && tile2[r][c] == Tile.D && tile3[r][c] == Tile.T)this.world[r][c].setStyle("-fx-background-color: Yellow");
                else if (tile1[r][c] == Tile.G && tile2[r][c] == Tile.T && tile3[r][c] == Tile.D)this.world[r][c].setStyle("-fx-background-color: Yellow");
                else if (tile1[r][c] == Tile.G && tile2[r][c] == Tile.D && tile3[r][c] == Tile.D)this.world[r][c].setStyle("-fx-background-color: Yellow");



                else if (tile2[r][c] == Tile.W && tile1[r][c] == Tile.T && tile3[r][c] == Tile.T)this.world[r][c].setStyle("-fx-background-color: red");
                else if (tile2[r][c] == Tile.W && tile1[r][c] == Tile.D && tile3[r][c] == Tile.T)this.world[r][c].setStyle("-fx-background-color: red");
                else if (tile2[r][c] == Tile.W && tile1[r][c] == Tile.T && tile3[r][c] == Tile.D)this.world[r][c].setStyle("-fx-background-color: red");
                else if (tile2[r][c] == Tile.W && tile1[r][c] == Tile.D && tile3[r][c] == Tile.D)this.world[r][c].setStyle("-fx-background-color: red");



                else if (tile3[r][c] == Tile.Q && tile2[r][c] == Tile.T && tile1[r][c] == Tile.T)this.world[r][c].setStyle("-fx-background-color: pink");
                else if (tile3[r][c] == Tile.Q && tile2[r][c] == Tile.D && tile1[r][c] == Tile.T)this.world[r][c].setStyle("-fx-background-color: pink");
                else if (tile3[r][c] == Tile.Q && tile2[r][c] == Tile.T && tile1[r][c] == Tile.D)this.world[r][c].setStyle("-fx-background-color: pink");
                else if (tile3[r][c] == Tile.Q && tile2[r][c] == Tile.D && tile1[r][c] == Tile.D)this.world[r][c].setStyle("-fx-background-color: pink");

               

            }
        }
    }

    public void resetWorld()
    {
        this.farm = new AntFarm();
        updateWorld(farm.getScreen(),farm.getScreen(),farm.getScreen());
        //updateWorld(farm.getScreen(),farm.getScreen());
        this.worker = new WorkingAnt();
        this.digger = new DiggingAnt();
        this.queen = new Queen();
        updateWorld(digger.getScreen(),worker.getScreen(), queen.getScreen());
        //updateWorld(digger.getScreen(),worker.getScreen());

    }

    public void runSimulation()
    {
        time = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Behavior antBehavior = new Behavior();
                antBehavior.moveRandom(digger, digger.getScreen());
                antBehavior.moveRandom(worker, worker.getScreen());
                antBehavior.moveRandom(queen, queen.getScreen());



                updateWorld(digger.getScreen(),worker.getScreen(),queen.getScreen());
                //updateWorld(digger.getScreen(),worker.getScreen());
            }
        };
            time.schedule(task, 0, farm.getPlayspeed());

    }

    public void update(){
        updateWorld(digger.getScreen(),worker.getScreen(), queen.getScreen());
        //updateWorld(digger.getScreen(),worker.getScreen());
       // updateWorld(farm.get(0).getScreenFromAL(),farm.get(1).getScreenFromAL());

    }

    public Ant getAnt() {
        return digger;
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