package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AntGui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        primaryStage.setTitle("Land of Future Ant Shenanigans!");

        WorldPane worldTiles = new WorldPane();
        Scene worldMap = new Scene(worldTiles, 850, 950);
        primaryStage.setScene(worldMap);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
