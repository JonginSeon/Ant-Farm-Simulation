package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;

public class WorldMenuBar extends MenuBar {

    private MenuHandler handler;

    private Menu fileMenu;

    private Menu speedMenu;

    private Menu runMenu;

    private Menu antMenu;

    private Menu infoMenu;

    private MenuItem startItem;

    private MenuItem pauseItem;

    private MenuItem resetItem;

    private MenuItem saveItem;

    private MenuItem loadItem;

    private MenuItem quitItem;

    private MenuItem workAntItem;

    private MenuItem digAntItem;

    private MenuItem infoItem;

    private MenuItem foodItem;
    private MenuItem oneSpeedItem;

    private MenuItem twoSpeedItem;

    private MenuItem threeSpeedItem;

    private MenuItem fourSpeedItem;


    private AntFarm farm;

    private WorldPane pane;



    public WorldMenuBar(WorldPane worldPane)
    {

        handler = new MenuHandler();

        pane = worldPane;

        farm = pane.getFarm();

        fileMenu = new Menu("File");

        antMenu = new Menu("Add Ants");

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

        workAntItem = new MenuItem("Working Ant");

        workAntItem.setOnAction(handler);

        digAntItem = new MenuItem("Digging Ant");

        digAntItem.setOnAction(handler);

        foodItem = new MenuItem("Food");

        foodItem.setOnAction(handler);

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

        antMenu.getItems().addAll(workAntItem, digAntItem,foodItem);

        speedMenu.getItems().addAll(oneSpeedItem, twoSpeedItem, threeSpeedItem, fourSpeedItem);

        infoMenu.getItems().addAll(infoItem);
        getMenus().addAll(fileMenu, runMenu, speedMenu, antMenu,infoMenu);


    }

    private class MenuHandler implements EventHandler<ActionEvent>
    {
        private boolean isRunning = false;

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
                }
                isRunning = false;
                FileChooser chooser = new FileChooser();
                File status = chooser.showOpenDialog(null);
                if(status != null)
                {
                    farm.load(status, farm.getScreen(), pane.getAnts());
                    pane.update();
                }
            }
            if(event.getSource() == workAntItem)
            {
                Ant[] ants = pane.getAnts();
                int numberOfAnts = pane.getNumberOfAnts();

                ants[numberOfAnts] = new WorkingAnt();
                pane.setNumberOfAnts(++numberOfAnts);
            }

            if(event.getSource() == digAntItem)
            {
                Ant[] ants = pane.getAnts();
                int numberOfAnts = pane.getNumberOfAnts();

                ants[numberOfAnts] = new DiggingAnt();
                pane.setNumberOfAnts(++numberOfAnts);
            }
            if(event.getSource() == foodItem)
            {
                Label l = new Label("no text input");
                TextInputDialog td = new TextInputDialog("Enter here");
                td.setHeaderText("How many food do you wnat?");
                td.showAndWait();
               // set the text of the label
                l.setText(td.getEditor().getText());
               Behavior behavior = new Behavior();
               String tem =td.getEditor().getText();
               int numberOfFood = Integer.parseInt(tem);
               behavior.foodGenerator(numberOfFood,farm.getScreen());



            }
            if(event.getSource() == infoItem)
            {



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
                    pane.getFarm().setPlayspeed(100);
            }
        }
    }
}