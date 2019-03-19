package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.File;

public class WorldMenuBar extends MenuBar {

    private MenuHandler handler;
    private Menu fileMenu;
    private Menu speedMenu;
    private Menu runMenu;

    private MenuItem startItem;
    private MenuItem pauseItem;
    private MenuItem resetItem;
    private MenuItem saveItem;
    private MenuItem loadItem;
    private MenuItem quitItem;

    private MenuItem oneSpeedItem;
    private MenuItem twoSpeedItem;
    private MenuItem threeSpeedItem;
    private MenuItem fourSpeedItem;


    private AntFarm farm;
    private WorldPane pane;

    public WorldMenuBar()
    {
        handler = new MenuHandler();
        farm = new AntFarm();
        pane = new WorldPane();

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

        loadItem = new MenuItem("Open File");
        loadItem.setOnAction(handler);

        quitItem = new MenuItem("Exit");
        quitItem.setOnAction(handler);

        oneSpeedItem = new MenuItem("1X Speed");
        oneSpeedItem.setOnAction(handler);

        twoSpeedItem = new MenuItem("2X Speed");
        twoSpeedItem.setOnAction(handler);

        threeSpeedItem = new MenuItem("3X Speed");
        threeSpeedItem.setOnAction(handler);

        fourSpeedItem = new MenuItem("4X Speed");
        fourSpeedItem.setOnAction(handler);

        fileMenu.getItems().addAll(saveItem, loadItem);
        runMenu.getItems().addAll(startItem, pauseItem, resetItem, quitItem);
        speedMenu.getItems().addAll(oneSpeedItem, twoSpeedItem, threeSpeedItem, fourSpeedItem);

        
        getMenus().addAll(fileMenu, runMenu, speedMenu);
    }

    private class MenuHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event) {

            if(event.getSource() == quitItem)
                System.exit(0);

            if(event.getSource() == saveItem)
            {
                FileChooser chooser = new FileChooser();
                File status = chooser.showSaveDialog(null);
                if(status != null) {
                    farm.save(farm.getScreen());
                }
            }

            if(event.getSource() == startItem)
            {
                
            }

            if(event.getSource() == resetItem )
            {

            }

            if(event.getSource() == pauseItem)
            {

            }

            if(event.getSource() == loadItem)
            {
                FileChooser chooser = new FileChooser();
                File status = chooser.showOpenDialog(null);
                if(status != null)
                {
                    String filename = status.getName();
                    farm.load(filename, farm.getScreen());
                }
            }

            if(event.getSource() == oneSpeedItem)
            {
               farm.setPlayspeed(1000);
               pane.runSimulation();

            }

            if(event.getSource() == twoSpeedItem)
            {
                farm.setPlayspeed(500);
                pane.runSimulation();
            }

            if(event.getSource() == threeSpeedItem)
            {
                farm.setPlayspeed(250);
                pane.runSimulation();
            }

            if(event.getSource() == fourSpeedItem)
            {
                farm.setPlayspeed(100);
                pane.runSimulation();
            }

        }
    }
}
