package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

/**
 * This class creates a menu bar that contains several buttons that
 * can influence the antfarm simulation depicted via WorldPane.
 *
 * @author Elijah, Jongin, Justin, Christian
 * @version 4/17/2019
 */
public class WorldMenuBar extends MenuBar {

    /**
     * This handles all the mouse-clicks on buttons.
     */
    private MenuHandler handler;
    /**
     * This opens a dropdown menu containing "Save" and "Load".
     */
    private Menu fileMenu;
    /**
     * This opens a dropdown menu containing speeds ".5X", "1X",
     * "2X", and "4x".
     */
    private Menu speedMenu;
    /**
     * This opens a dropdown menu containing "Start", "Pause",
     * "Reset", and "Exit".
     */
    private Menu runMenu;
    /**
     * This opens a dropdown menu containing "DiggingAnt",
     * "WorkingAnt", and "King".
     */
    private Menu storeMenu;
    /**
     * This opens a dropdown menu containing "Info".
     */
    private Menu infoMenu;

    /**
     * This button starts the simulation.
     */
    private MenuItem startItem;
    /**
     * This button pauses the simulation.
     */
    private MenuItem pauseItem;
    /**
     * This button resets the simulation.
     */
    private MenuItem resetItem;
    /**
     * This button saves the simulation to a textfile.
     */
    private MenuItem saveItem;
    /**
     * This button loads a previous simulation from a textfile.
     */
    private MenuItem loadItem;
    /**
     * This button exits the simulation.
     */
    private MenuItem quitItem;
    /**
     * This button purchases a workerAnt.
     */
    private MenuItem workAntItem;
    /**
     * This button purchases a diggingAnt.
     */
    private MenuItem digAntItem;
    /**
     * This button purchases a king ant.
     */
    private MenuItem kingAntItem;
    /**
     * This button opens up a panel displaying info
     * about the current simulation.
     */
    private MenuItem infoItem;
    /**
     * This button changes the simulation to half it's default speed.
     */
    private MenuItem oneSpeedItem;
    /**
     * This button changes the simulation to its default speed.
     */
    private MenuItem twoSpeedItem;
    /**
     * This button changes the simulation to 2X its default speed.
     */
    private MenuItem threeSpeedItem;
    /**
     * This button changes the simulation to 4X its default speed.
     */
    private MenuItem fourSpeedItem;

    /**
     * This AntFarm object is used to learn the positions of the ants.
     */
    private AntFarm farm;
    /**
     * This is the WorldPane on which the menu button will cause changes.
     */
    private WorldPane pane;

    /**
     * Creates a WorldMenubar object with 5 menus and 14 menu
     * items and assigns each of them to an event listener.
     * This WorldMenuBar will cause changes in the WorldPane
     * class given as its parameter.
     *
     * @param worldPane The WorldPane object that this WorldMenuBar will affect.
     */
    public WorldMenuBar(WorldPane worldPane) {

        handler = new MenuHandler();
        pane = worldPane;
        farm = pane.getFarm();

        fileMenu = new Menu("File");
        storeMenu = new Menu("Store");
        runMenu = new Menu("Run");
        speedMenu = new Menu("Speeds");
        infoMenu = new Menu("Info");

        resetItem = new MenuItem("Reset");
        resetItem.setOnAction(handler);

        startItem = new MenuItem("Start Simulation");
        startItem.setOnAction(handler);

        pauseItem = new MenuItem("Pause");
        pauseItem.setOnAction(handler);

        saveItem = new MenuItem("Save File");
        saveItem.setOnAction(handler);

        loadItem = new MenuItem("Open File");
        loadItem.setOnAction(handler);

        quitItem = new MenuItem("Exit");
        quitItem.setOnAction(handler);

        workAntItem = new MenuItem("Working Ant -> $5");
        workAntItem.setOnAction(handler);

        digAntItem = new MenuItem("Digging Ant -> $2");
        digAntItem.setOnAction(handler);

        kingAntItem = new MenuItem("King Ant -> $10");
        kingAntItem.setOnAction(handler);

        infoItem = new MenuItem("Information");
        infoItem.setOnAction(handler);

        oneSpeedItem = new MenuItem(".5X Speed");
        oneSpeedItem.setOnAction(handler);

        twoSpeedItem = new MenuItem("1X Speed");
        twoSpeedItem.setOnAction(handler);

        threeSpeedItem = new MenuItem("2X Speed");
        threeSpeedItem.setOnAction(handler);

        fourSpeedItem = new MenuItem("4X Speed");
        fourSpeedItem.setOnAction(handler);

        fileMenu.getItems().addAll(saveItem, loadItem, quitItem);
        runMenu.getItems().addAll(startItem, pauseItem, resetItem);
        storeMenu.getItems().addAll(digAntItem, workAntItem, kingAntItem);
        speedMenu.getItems().addAll(oneSpeedItem, twoSpeedItem,
                threeSpeedItem, fourSpeedItem);
        infoMenu.getItems().addAll(infoItem);

        getMenus().addAll(fileMenu, runMenu, speedMenu, storeMenu, infoMenu);

    }

    /**
     * This class registers when any of the menu buttons have been clicked and
     * does the appropriate action depending on which one was selected.
     */
    private class MenuHandler implements EventHandler<ActionEvent> {

        /**
         * Shows whether or not the simulation is running.
         */
        private boolean isRunning = false;

        /**
         * Creates a small popup window to notify the user that they have
         * selected an ant that they do not have enough food to build.
         */
        private void makePopUpMenu() {
            Stage popupwindow2 = new Stage();
            popupwindow2.initModality(Modality.APPLICATION_MODAL);
            Label label = new Label("Mine more food!"
                    + "\n" + "Current Food: " + pane.getFoodObtained());

            Button button1 = new Button("Close");
            button1.setOnAction(e -> popupwindow2.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button1);

            layout.setAlignment(Pos.CENTER);

            Scene scene1 = new Scene(layout, 100, 150);
            popupwindow2.setScene(scene1);
            popupwindow2.showAndWait();
        }

        /**
         * Determines which button has been clicked and
         * executes the appropriate commands.
         *
         * @param event A mouse-click on any of the menu buttons
         */
        public void handle(ActionEvent event) {
            if (event.getSource() == quitItem) {
                System.exit(0);
            }

            if (event.getSource() == saveItem) {
                Ant[] theseAnts = pane.getAnts();
                Queen queen = (Queen) theseAnts[0];
                if (queen.getNestCenterX() >= 0) {
                    if (isRunning) {
                        pane.stopSimulation();
                        isRunning = false;
                    }
                    FileChooser chooser = new FileChooser();
                    File status = chooser.showSaveDialog(null);
                    if (status != null) {
                        pane.getFarm().save(pane.getFarm().getScreen(), status);
                    }
                }
            }


            if (event.getSource() == startItem) {
                if (!isRunning) {
                    pane.runSimulation();
                    isRunning = true;
                }
            }

            if (event.getSource() == resetItem) {
                if (isRunning) {
                    pane.stopSimulation();
                }
                pane.resetWorld();
                farm = pane.getFarm();
                isRunning = false;
            }

            if (event.getSource() == pauseItem) {
                if (isRunning) {
                    pane.stopSimulation();
                }
                isRunning = false;
            }

            if (event.getSource() == loadItem) {
                if (isRunning) {
                    pane.stopSimulation();
                }
                isRunning = false;
                FileChooser chooser = new FileChooser();
                File status = chooser.showOpenDialog(null);
                if (status != null) {
                    farm.load(status, farm.getScreen(), pane.getAnts());
                    pane.update();
                    int count = 0;
                    Ant[] theseAnts = pane.getAnts();
                    for (Ant theseAnt : theseAnts) {
                        if (theseAnt != null) {
                            count++;
                        }
                    }
                    pane.setNumberOfAnts(count);
                }
            }
            if (event.getSource() == workAntItem) {
                Ant[] ants = pane.getAnts();
                int numberOfAnts = pane.getNumberOfAnts();

                Queen ant = (Queen) ants[0];
                if (ant.getNestCenterX() != -1) {

                    if (pane.getFoodObtained() >= 5) {
                        ants[numberOfAnts] = new WorkingAnt(
                                ant.getNestCenterX() - 1, ant.getNestCenterY());
                        pane.setNumberOfAnts(++numberOfAnts);
                        pane.setFoodObtained(pane.getFoodObtained() - 5);
                    } else if (pane.getFoodObtained() < 5) {
                        makePopUpMenu();
                    }
                }
            }

            if (event.getSource() == digAntItem) {
                Behavior behavior = new Behavior();
                Ant[] ants = pane.getAnts();
                int numberOfAnts = pane.getNumberOfAnts();

                Queen ant = (Queen) ants[0];
                if (ant.getNestCenterX() != -1) {
                    if (pane.getFoodObtained() >= 2) {
                        ants[numberOfAnts] = new DiggingAnt(
                                ant.getNestCenterX() - 1, ant.getNestCenterY());
                        pane.setNumberOfAnts(++numberOfAnts);

                        pane.setFoodObtained(pane.getFoodObtained() - 2);
                    } else if (pane.getFoodObtained() < 2) {
                        makePopUpMenu();
                    }
                }
            }

            if (event.getSource() == kingAntItem) {
                Behavior behavior = new Behavior();
                Ant[] ants = pane.getAnts();
                int numberOfAnts = pane.getNumberOfAnts();

                Queen ant = (Queen) ants[0];
                if (ant.getNestCenterX() != -1) {
                    if (pane.getFoodObtained() >= 10) {
                        ants[numberOfAnts] = new King(ant.getNestCenterX()
                                - 1, ant.getNestCenterY());
                        pane.setNumberOfAnts(++numberOfAnts);

                        pane.setFoodObtained(pane.getFoodObtained() - 10);
                    } else if (pane.getFoodObtained() < 10) {
                        makePopUpMenu();
                    }
                }
            }


            if (event.getSource() == infoItem) {
                Stage popupwindow = new Stage();
                popupwindow.initModality(Modality.APPLICATION_MODAL);
                popupwindow.setTitle("Current Ant Farm Info");
                String numOfFood =
                        Integer.toString(farm.foodCounter());
                String numOfWorkingant = Integer.toString(
                        farm.workingAntCounter(farm.getScreen()));
                String numOfDiggingant = Integer.toString(
                        farm.diggingAntCounter(farm.getScreen()));
                String numOfQueen = Integer.toString(
                        farm.queenCounter(farm.getScreen()));
                String numOfKing = Integer.toString(
                        farm.kingCounter(farm.getScreen()));
                String numOfFoodObtained = Integer.toString(
                        pane.getFoodObtained());

                // Label label1= new Label("Source: "+numOfFood);
                Label label1 = new Label("Food Obtained: "
                        + numOfFoodObtained);

                Label label2 = new Label("Queen: " + numOfQueen);
                Label label3 = new Label("King: " + numOfKing);
                Label label4 = new Label("DiggingAnt: "
                        + numOfDiggingant);
                Label label5 = new Label("WorkingAnt: "
                        + numOfWorkingant);


                Button button1 = new Button("Close");
                button1.setOnAction(e -> popupwindow.close());


                VBox layout = new VBox(10);
                layout.getChildren().addAll(
                        label1, label2, label3, label4, label5, button1);

                layout.setAlignment(Pos.CENTER);

                Scene scene1 = new Scene(layout, 300, 250);
                popupwindow.setScene(scene1);
                popupwindow.showAndWait();

            }

            if (event.getSource() == oneSpeedItem) {
                if (isRunning) {
                    pane.stopSimulation();
                    pane.getFarm().setPlayspeed(1000);
                    pane.runSimulation();
                } else {
                    pane.getFarm().setPlayspeed(1000);
                }
            }

            if (event.getSource() == twoSpeedItem) {
                if (isRunning) {
                    pane.stopSimulation();
                    pane.getFarm().setPlayspeed(500);
                    pane.runSimulation();
                } else {
                    pane.getFarm().setPlayspeed(500);
                }
            }

            if (event.getSource() == threeSpeedItem) {
                if (isRunning) {
                    pane.stopSimulation();
                    pane.getFarm().setPlayspeed(250);
                    pane.runSimulation();
                } else {
                    pane.getFarm().setPlayspeed(250);
                }
            }

            if (event.getSource() == fourSpeedItem) {
                if (isRunning) {
                    pane.stopSimulation();
                    pane.getFarm().setPlayspeed(100);
                    pane.runSimulation();
                } else {
                    pane.getFarm().setPlayspeed(100);
                }
            }
        }
    }
}
