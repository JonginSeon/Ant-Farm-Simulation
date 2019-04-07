package main;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.event.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class creates and updates an array of multi-colored buttons
 * by analyzing the Tile array from an AntFarm object.
 * @author Elijah Smith
 * @version 4/06/2019
 */
public class WorldPane extends AnchorPane {

    private Button[][] world; /** This array of buttons composes the visible gui. */
    private AntFarm farm; /** This Antfarm object is analyzed to determine the color of each button. */
    private Ant ant; /** This is used to effect Ant tiles specifically. */

    /**
     * The timer is used to continually update the array of buttons and
     * create the illusion of ant movement.
     */
    private Timer time;

    /**
     * The basic constructor. It creates the Tilepane the will be the foundation
     * of the gui and adds to it the default array of buttons using the createworld method.
     */
    public WorldPane() {

        farm = new AntFarm();
        ant = new Ant();
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

    /**
     * @return farm
     */
    public AntFarm getFarm() {
        return this.farm;
    }

    /**
     * This method creates a 100 x 100 array of buttons, colors them in their
     * default coloration, and assigns each to an actionlistener. The array is
     * then placed onto the specified Tilepane.
     * @param tilePane The foundation for the array of buttons
     * @param handler The actionlistener to which each button will be assigned
     */
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

    /**
     * This method iterates through button array and changes each button's
     * color according to the corresponding array index in the Tile array.
     * @param tile The Tile array from an AntFarm object
     */
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

    /**
     * This method resets the gui to its default state by creating
     * a new AntFarm Tile array and updating the buttons to display
     * its corresponding colors.
     */
    public void resetWorld()
    {
        this.farm = new AntFarm();
        updateWorld(farm.getScreen());
    }

    /**
     * This method runs the simulation by setting a series of commands that
     * execute repeatedly execute every 500 milliseconds (Default Time) on a timer.
     * First, farm.moverandom changes the position of the ant in its Tile array.
     * Second, the WorldPane gui is updated using updateWorld.
     */
    public void runSimulation()
    {
        time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                farm.moveRandomDiag(ant); //TODO: ANT ONLY MOVES DIAG
                updateWorld(farm.getScreen());
            }
        };

        time.schedule(task, 0, farm.getPlayspeed());
    }

    /**
     * This methods cancels the timer, stopping the series of commands
     * that are executed in the runSimulation method.
     */
    public void stopSimulation()
    {
        time.cancel();
    }

    /**
     * This method calls the updateWorld method once.
     */
    public void update()
    {
        updateWorld(farm.getScreen());
    }

    /**
     * @return ant
     */
    public Ant getAnt()
    {
        return ant;
    }

    /**
     * This class acts as the actionListener for all of the buttons in the button array.
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {

        /**
         * This method determines which button was clicked in the button array and
         * then changes the button's color to black.
         * @param event A mouse click on a button
         */
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