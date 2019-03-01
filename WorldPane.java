package main;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.event.*;

public class WorldPane extends AnchorPane {

    private Button[][] world;

    public WorldPane() {
        ButtonHandler handler = new ButtonHandler();

        TilePane tilePane = new TilePane();
        tilePane.setPrefTileHeight(10.0);
        tilePane.setPrefTileWidth(10.0);
        tilePane.setHgap(0.0);
        tilePane.setVgap(0.0);
        tilePane.setTileAlignment(Pos.TOP_LEFT);

        createWorld(tilePane, handler);

        setTopAnchor(tilePane, 0.0);
        setBottomAnchor(tilePane, 0.0);
        setRightAnchor(tilePane, 0.0);
        setLeftAnchor(tilePane, 0.0);

        getChildren().add(tilePane);
    }


    private void createWorld(TilePane tilePane, ButtonHandler handler) {
        Button btn;

        this.world = new Button[100][100];

        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                btn = new Button();
                btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                if (r <= 10) {
                    btn.setStyle("-fx-background-color: DeepSkyBlue");
                } else {
                    btn.setStyle("-fx-background-color: Peru");
                }
                btn.setOnAction(handler);
                tilePane.getChildren().add(btn);
                this.world[r][c] = btn;
            }
        }
    }

    private void updateWorld(Tile[][] tile)
    {
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {

                if (tile[r][c] == Tile.S)
                    this.world[r][c].setStyle("-fx-background-color: DeepSkyBlue");
                else if (tile[r][c] == Tile.D)
                    this.world[r][c].setStyle("-fx-background-color: Peru");
                else if (tile[r][c] == Tile.T)
                    this.world[r][c].setStyle("-fx-background-color: Black");
                else if (tile[r][c] == Tile.A)
                    this.world[r][c].setStyle("-fx-background-color: Red");

            }
        }
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {

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



