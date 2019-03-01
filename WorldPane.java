package main;

import javafx.event.EventHandler;

import javafx.geometry.Pos;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.TilePane;

import javafx.scene.control.Button;

import javafx.event.*;


public class WorldPane extends AnchorPane

{
    /**Holds menu bar*/
//    private MenuBar menus;
//
//    private Menu fileMenu;
    //private Menu actionMenu;

//    private MenuItem saveItem;
//    private MenuItem loadItem;
//    private MenuItem quitItem;

    private Button[][] world;


    //private Tile[][] farm;
    private AntFarm Farm;


    public WorldPane()
    {
        // Adding menu bar and menu items
//        menus = new MenuBar();
//        fileMenu = new Menu("File");
//        saveItem = new MenuItem("Save File");
//        loadItem = new MenuItem("Open File");
//        quitItem = new MenuItem("Exit");

        //adding item to bar
//        fileMenu.getItems().add(saveItem);
//        fileMenu.getItems().add(loadItem);
//        fileMenu.getItems().add(quitItem);
//
//        menus.getMenus().add(fileMenu);


//        Farm = new AntFarm();


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