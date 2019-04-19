package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This class combines the WorldPane and WorldMenuBar classes into an
 * observable gui. Because it is only the final step in the creation process,
 * its contents are fairly small.
 *
 * @author Elijah Smith
 * @version 4/17/2019
 */
public class AntGui extends Application {

    /**
     * Creates the Antfarm map using a WorldPane and a WorldMenuBar class.
     * @param primaryStage The screen on which all content will display
     */
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Land of Honest, Hardworking Ant-Folk");

        BorderPane root = new BorderPane();

        WorldPane worldTiles = new WorldPane();
        WorldMenuBar menuBar = new WorldMenuBar(worldTiles);

        root.setTop(menuBar);
        root.setCenter(worldTiles);

        Scene worldMap = new Scene(root, 905, 940);
        primaryStage.setScene(worldMap);
        primaryStage.show();


    }

    /**
     * Begins the simulation.
     * @param args This should always be empty
     */
    public static void main(String[] args) {
        launch(args);
    }
}
