package main;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This class creates and updates an array of multi-colored labels
 * by analyzing the Tile array from an AntFarm object.
 *
 * @author Elijah, Jongin, Justin
 * @version 4/12/2019
 */
public class WorldPane extends AnchorPane {

    /**
     * This array of labels composes the visible gui.
     */
    private Label[][] world;
    /**
     * This Antfarm object is analyzed to determine the color of each label.
     */
    private AntFarm farm;
    /**
     * The different ants the inhabit the simulation.
     */
    private Ant[] ants;
    /**
     * The amount of food that can be used to purchase ants.
     */
    private int foodObtained;
    /**
     * The number of ants inhabiting the simulation.
     */
    private int numberOfAnts;
    /**
     * The number of times the timer loop has executed.
     */
    private int count;
    /**
     * The single queen Ant that begins each simulation.
     */
    private Ant queen = new Queen();
    /**
     * This is used to make changes to the gui every second.
     */
    private Timer time;

    /**
     * Creates a WorldPane with a 100 x 100 array of labels and a
     * maximum of 10 ants.
     */
    public WorldPane() {

        farm = new AntFarm();
        numberOfAnts = 0;
        count = 0;
        ants = new Ant[50];
        foodObtained = 30; //TODO Change to better value once testing is done

        TilePane tilePane = new TilePane();

        tilePane.setPrefTileHeight(9.0);
        tilePane.setPrefTileWidth(9.0);
        tilePane.setHgap(0.0);
        tilePane.setVgap(0.0);
        tilePane.setTileAlignment(Pos.TOP_LEFT);

        createWorld(tilePane);

        setTopAnchor(tilePane, 0.0);
        setBottomAnchor(tilePane, 0.0);
        setRightAnchor(tilePane, 0.0);
        setLeftAnchor(tilePane, 0.0);

        setMaxSize(900, 945);
        setMinSize(900, 945);

        getChildren().add(tilePane);
    }

    /**
     * Gets the current Antfarm object used.
     *
     * @return the current Antfarm object.
     */
    public AntFarm getFarm() {
        return this.farm;
    }

    /**
     * Creates a TilePane to be added as a child to the WorldPane class.
     * The TilePane is composed of 101 x 100 colored labels, each representing
     * a tile type defined by their position. Row 101 is colored
     * white to address stretching issues.
     *
     * @param tilePane The TilePane object to be initialized.
     */
    public void createWorld(TilePane tilePane) {

        ants[0] = queen;
        numberOfAnts += 1;
        this.world = new Label[101][100];

        Label lbl;
        for (int r = 0; r < 101; r++) {
            for (int c = 0; c < 100; c++) {
                lbl = new Label();
                lbl.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                if (r < 10) {
                    lbl.setStyle("-fx-background-color: DeepSkyBlue");
                } else if (r == 100) {
                    lbl.setStyle("-fx-background-color: White");
                } else {
                    lbl.setStyle("-fx-background-color: Peru");
                }

                tilePane.getChildren().add(lbl);
                this.world[r][c] = lbl;
            }
        }
    }

    /**
     * Updates the WorldPane to reflect a given 100 x 100 Tile array.
     * Each tile corresponds to a unique label color.
     *
     * @param screen The Tile array that is scanned
     */
    public void updateWorld(Tile[][] screen) {
        for (int r = 0; r < 100; r++) {

            for (int c = 0; c < 100; c++) {

                //only sky
                if (screen[r][c] == Tile.S) {
                    this.world[r][c].setStyle(
                            "-fx-background-color: DeepSkyBlue");

                } else if (screen[r][c] == Tile.D) {  //only dirt
                    this.world[r][c].setStyle(
                            "-fx-background-color: Peru");

                } else if (screen[r][c] == Tile.T) {  //only tile
                    this.world[r][c].setStyle(
                            "-fx-background-color: SaddleBrown");
                } else if (screen[r][c] == Tile.Q) {
                    this.world[r][c].setStyle(
                            "-fx-background-color: Pink");
                } else if (screen[r][c] == Tile.G) {
                    this.world[r][c].setStyle(
                            "-fx-background-color: Yellow");
                } else if (screen[r][c] == Tile.W) {
                    this.world[r][c].setStyle(
                            "-fx-background-color: red");
                } else if (screen[r][c] == Tile.F) {
                    this.world[r][c].setStyle(
                            "-fx-background-color: Green");
                } else if (screen[r][c] == Tile.K) {
                    this.world[r][c].setStyle(
                            "-fx-background-color: Black");
                }

            }
        }
    }

    /**
     * Resets the WorldPane to its default coloration and ant amount.
     */
    public void resetWorld() {
        this.farm = new AntFarm();
        updateWorld(farm.getScreen());

        this.ants = new Ant[50];
        this.numberOfAnts = 0;
        this.queen = new Queen();
        ants[0] = queen;
        numberOfAnts += 1;
        updateWorld(farm.getScreen());
    }

    /**
     * Gets the value of the property foodObtained.
     *
     * @return the value of foodObtained
     */
    public int getFoodObtained() {
        return foodObtained;
    }

    /**
     * Sets the value of property foodObtained.
     *
     * @param foodObtained The amount of food collected
     */
    public void setFoodObtained(int foodObtained) {
        this.foodObtained = foodObtained;
    }

    /**
     * Sets a number of actions to a timer that simulate an
     * Ant Farm on the WorldPane and therefore also on the
     * visible gui.
     */
    public void runSimulation() {
        time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Behavior antBehavior = new Behavior();
                Tile currentAnt;
                for (int i = 0; i < numberOfAnts; i++) {
                    currentAnt = ants[i].getAntTile();
                    switch (currentAnt) {

                        case Q:
                            antBehavior.digToBottom(
                                    (Queen) ants[i], farm.getScreen());
                            break;

                        case W:
                            antBehavior.moveRandomCross(
                                    ants[i], farm.getScreen());
                            break;

                        case G:
                            antBehavior.moveRandomDiag(
                                    ants[i], farm.getScreen());
                            break;

                        case K:
                            antBehavior.moveRandom(
                                    ants[i], farm.getScreen());
                            break;

                        default:
                            break;

                    }
                }
                if (antBehavior.getFoodObtained() == 1
                        || antBehavior.getFoodObtained() == 2
                        || antBehavior.getFoodObtained() == 3) {
                    foodObtained++;
                }

                count++;
                if (foodObtained > 30) {
                    if (count % 10 == 0) {
                        antBehavior.foodGenerator(farm.getScreen());
                    }
                } else if (foodObtained <= 30) {
                    if (count % 5 == 0) {
                        antBehavior.foodGenerator(farm.getScreen());
                    }
                }

                updateWorld(farm.getScreen());
            }
        };
        time.schedule(task, 0, farm.getPlayspeed());
    }

    /**
     * Updates the world once using the currently defined AntFarm object.
     */
    public void update() {
        updateWorld(farm.getScreen());
    }

    /**
     * Gets the current Ant array.
     *
     * @return All the active ants in the simulation
     */
    public Ant[] getAnts() {
        return ants;
    }

    /**
     * Sets the value of the property numberOfAnts.
     *
     * @param noa The new number of ants
     */
    public void setNumberOfAnts(int noa) {
        this.numberOfAnts = noa;
    }

    /**
     * Gets the number of ant in the simulation.
     *
     * @return The number of Ants
     */
    public int getNumberOfAnts() {
        return numberOfAnts;
    }

    /**
     * Stop the timer if it is running in runSimulation() and therefore
     * stop the simulation.
     */
    public void stopSimulation() {
        time.cancel();
    }
}
