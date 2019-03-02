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


    private AntFarm farm;

    public WorldMenuBar()
    {
        handler = new MenuHandler();

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

        fileMenu.getItems().addAll(saveItem, loadItem);
        runMenu.getItems().addAll(startItem, pauseItem, resetItem, quitItem);

        
        getMenus().addAll(fileMenu);
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

        }
    }
}
