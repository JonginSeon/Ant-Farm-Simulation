package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class WorldMenuBar extends MenuBar {

    private MenuHandler handler;
    private Menu fileMenu;
    private MenuItem saveItem;
    private MenuItem loadItem;
    private MenuItem quitItem;

    private AntFarm farm;

    public WorldMenuBar()
    {
        handler = new MenuHandler();

        fileMenu = new Menu("File");

        saveItem = new MenuItem("Save File");
        saveItem.setOnAction(handler);

        loadItem = new MenuItem("Open File");
        loadItem.setOnAction(handler);

        quitItem = new MenuItem("Exit");
        quitItem.setOnAction(handler);

        fileMenu.getItems().addAll(saveItem, loadItem, quitItem);
        getMenus().addAll(fileMenu);
    }

    private class MenuHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event) {

            if(event.getSource() == quitItem)
                System.exit(0);

            if(event.getSource() == saveItem)
            {
                //farm.save()
            }

            if(event.getSource() == loadItem)
            {

            }

        }
    }
}
