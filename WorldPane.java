package main;



import javafx.event.EventHandler;

import javafx.geometry.Pos;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.TilePane;

import javafx.scene.control.Button;

import javafx.event.*;



public class WorldPane extends AnchorPane

{



    private Button[][] world;

    //private Tile[][] farm;



    public WorldPane()

    {

        ButtonHandler handler = new ButtonHandler();



        TilePane tilePane = new TilePane();

        tilePane.setPrefColumns(50);



        tilePane.setTileAlignment(Pos.TOP_LEFT);

        createWorld(tilePane, handler);



        setTopAnchor(tilePane,0.0);

        setBottomAnchor(tilePane, 0.0);

        setRightAnchor(tilePane, 0.0);

        setLeftAnchor(tilePane, 0.0);



        getChildren().add(tilePane);

    }







    private void createWorld(TilePane tilePane, ButtonHandler handler)

    {

        Button btn;



        this.world = new Button[50][50];



        for (int r = 0; r < 50; r++){

            for (int c = 0; c < 50; c++){

                btn = new Button();

                if (r <= 5)

                {

                    btn.setStyle("-fx-background-color: DeepSkyBlue");

                }

                else {

                    btn.setStyle("-fx-background-color: Peru");

                }

                btn.setOnAction(handler);

                tilePane.getChildren().add(btn);

                this.world[r][c] = btn;

            }

        }

    }







    private class ButtonHandler implements EventHandler<ActionEvent> {



        @Override

        public void handle(ActionEvent event) {



            for (int r = 0; r < 50; r++) {

                for (int c = 0; c < 50; c++) {

                    if (world[r][c] == event.getSource()) {

                        world[r][c].setStyle("-fx-background-color: Black");

                    }

                }

            }

        }



    }

}