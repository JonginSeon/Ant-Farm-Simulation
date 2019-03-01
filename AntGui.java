package main;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.Button;

import javafx.scene.layout.TilePane;

import javafx.stage.Stage;
/**********************************************************************
 * Description: This is the class that displays the GUI to the user
 * and allows user to start, pause or speed up the Ant Farm simulation.
 * It also allows users to save and load the game into a file.
 * @author Christian Tsoungui
 *
 *********************************************************************/

public class AntGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));

        primaryStage.setTitle("Land of Future Ant Shenanigans!");

        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");;
        MenuItem saveItem = new MenuItem("Save File");
        MenuItem loadItem = new MenuItem("Open File");
        MenuItem quitItem = new MenuItem("Exit");

        quitItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        saveItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });


        fileMenu.getItems().addAll(saveItem, loadItem, quitItem);
        menuBar.getMenus().add(fileMenu);
        //Put menubar at the top BoarderPane root
        root.setTop(menuBar);
        //Create WorldPane object worldTiles
        WorldPane worldTiles = new WorldPane();

        //set worldTiles at center of root
        root.setCenter(worldTiles);

        //create new Scene worldMap
        Scene worldMap = new Scene(root, 500, 500);
        //set wordMap as primary stage
        primaryStage.setScene(worldMap);

        //Maximize window when it opens
        primaryStage.setMaximized(true);

        //display world
        primaryStage.show();


    }







}