package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AntGui extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Land of Growing Ant-Sophistication!");

        BorderPane root = new BorderPane();

        WorldPane worldTiles = new WorldPane();
        WorldMenuBar menuBar = new WorldMenuBar(worldTiles);

        root.setTop(menuBar);
        root.setCenter(worldTiles);

        Scene worldMap = new Scene(root,905, 945);
        primaryStage.setScene(worldMap);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}