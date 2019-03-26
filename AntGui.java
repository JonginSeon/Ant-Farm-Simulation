package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AntGui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Land of Unchecked Ant Shenanigans!");

        BorderPane root = new BorderPane();

        WorldPane worldTiles = new WorldPane();
        WorldMenuBar menuBar = new WorldMenuBar(worldTiles);

        root.setTop(menuBar);
        root.setCenter(worldTiles);

        Scene worldMap = new Scene(root, 1000, 950);
        primaryStage.setScene(worldMap);
        primaryStage.show();

        //worldTiles.runSimulation();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
