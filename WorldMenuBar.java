package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import java.io.File;

/**
 * This class creates a menu bar that contains several buttons that
 * can influence the antfarm simulation depicted via WorldPane.
 * @author Elijah and Christian
 * @version 4/06/2019
 */
public class WorldMenuBar extends MenuBar {

    private MenuHandler handler; /** This handles all the mouse-clicks on buttons */
    private Menu fileMenu; /** This opens a dropdown menu containing "Save" and "Load" */
    private Menu speedMenu; /** This opens a dropdown menu containing speeds ".5X", "1X", "2X", and "4x" */
    private Menu runMenu; /** This opens a dropdown menu containing "Start", "Pause", "Reset", and "Exit" */

    private MenuItem startItem; /** This button starts the simulation */
    private MenuItem pauseItem; /** This button pauses the simulation */
    private MenuItem resetItem; /** This button resets the simulation */
    private MenuItem saveItem; /** This button saves the simulation to a textfile */
    private MenuItem loadItem; /** This button loads a previous simulation from a textfile */
    private MenuItem quitItem; /** This button exits the simulation */

    private MenuItem oneSpeedItem; /** This button changes the simulation to half it's default speed */
    private MenuItem twoSpeedItem; /** This button changes the simulation to its default speed */
    private MenuItem threeSpeedItem; /** This button changes the simulation to 2X its default speed */
    private MenuItem fourSpeedItem; /** This button changes the simulation to 4X its default speed */

    private WorldPane pane; /** This is the WorldPane on which the menu button which cause changes */

    /**
     * The standard constructor. It instantiates all the menu items and assigns them each
     * the appropriate name and event handler.
     * @param worldPane The worldPane that this class will make changes to
     */
    public WorldMenuBar(WorldPane worldPane)
    {

        handler = new MenuHandler();
        pane = worldPane;

        fileMenu = new Menu("File");
        runMenu = new Menu("Run");
        speedMenu = new Menu("Speeds");

        resetItem = new MenuItem("Reset");
        resetItem.setOnAction(handler);

        startItem = new MenuItem("Start Simulation");
        startItem.setOnAction(handler);

        pauseItem = new MenuItem("Pause");
        pauseItem.setOnAction(handler);

        saveItem = new MenuItem("Save File");
        saveItem.setOnAction(handler);

        loadItem = new MenuItem("Load File");
        loadItem.setOnAction(handler);

        quitItem = new MenuItem("Exit");
        quitItem.setOnAction(handler);

        oneSpeedItem = new MenuItem(".5X Speed");
        oneSpeedItem.setOnAction(handler);

        twoSpeedItem = new MenuItem("1X Speed");
        twoSpeedItem.setOnAction(handler);

        threeSpeedItem = new MenuItem("2X Speed");
        threeSpeedItem.setOnAction(handler);

        fourSpeedItem = new MenuItem("4X Speed");
        fourSpeedItem.setOnAction(handler);

        fileMenu.getItems().addAll(saveItem, loadItem);
        runMenu.getItems().addAll(startItem, pauseItem, resetItem, quitItem);
        speedMenu.getItems().addAll(oneSpeedItem, twoSpeedItem, threeSpeedItem, fourSpeedItem);

        getMenus().addAll(fileMenu, runMenu, speedMenu);

    }

    /**
     * This class registers when any of the menu buttons have been clicked and
     * does the appropriate action depending on which one was selected.
     */
    private class MenuHandler implements EventHandler<ActionEvent>
    {
        private boolean isRunning = false; /** This tracks whether the simulation is currently running */

        /**
         * This method determines which button has been clicked and executes the appropriate commands.
         * @param event A mouse-click on any of the menu buttons
         */
        public void handle(ActionEvent event) {
            if(event.getSource() == quitItem)
            {
                System.exit(0);
            }

            if(event.getSource() == saveItem)
            {
                if (isRunning) {
                    pane.stopSimulation();
                    isRunning = false;
                }

                FileChooser chooser = new FileChooser();
                File status = chooser.showSaveDialog(null);
                if(status != null) {
                    pane.getFarm().save(pane.getFarm().getScreen(), status);
                }
            }

            if(event.getSource() == startItem)
            {
                pane.runSimulation();
                isRunning = true;
            }

            if(event.getSource() == resetItem )
            {
                if (isRunning)
                    pane.stopSimulation();
                pane.resetWorld();
                isRunning = false;
            }

            if(event.getSource() == pauseItem)
            {
                if (isRunning)
                    pane.stopSimulation();
                isRunning = false;
            }

            if(event.getSource() == loadItem)
            {
                if (isRunning) {
                    pane.stopSimulation();
                    isRunning = false;
                }

                FileChooser chooser = new FileChooser();
                File status = chooser.showOpenDialog(null);
                if(status != null)
                {
                    pane.getFarm().load(status, pane.getFarm().getScreen(), pane.getAnt());
                    pane.update();
                }
            }

            if(event.getSource() == oneSpeedItem)
            {
                if (isRunning) {
                    pane.stopSimulation();
                    pane.getFarm().setPlayspeed(1000);
                    pane.runSimulation();
                }
                else
                    pane.getFarm().setPlayspeed(1000);
            }

            if(event.getSource() == twoSpeedItem)
            {

                if (isRunning) {
                    pane.stopSimulation();
                    pane.getFarm().setPlayspeed(500);
                    pane.runSimulation();
                }
                else
                    pane.getFarm().setPlayspeed(500);
            }

            if(event.getSource() == threeSpeedItem)
            {
                if (isRunning) {
                    pane.stopSimulation();
                    pane.getFarm().setPlayspeed(250);
                    pane.runSimulation();
                }
                else
                    pane.getFarm().setPlayspeed(250);

            }

            if(event.getSource() == fourSpeedItem)

            {
                if (isRunning) {
                    pane.stopSimulation();
                    pane.getFarm().setPlayspeed(100);
                    pane.runSimulation();
                }
                else
                    pane.getFarm().setPlayspeed(125);
            }
        }
    }
}