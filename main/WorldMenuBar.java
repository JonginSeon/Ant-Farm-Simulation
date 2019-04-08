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
    private Ant Ants;

    private WorldPane pane;

    Ant workingAnt = new WorkingAnt();
    Ant diggAnt = new DiggingAnt();


    public WorldMenuBar(WorldPane worldPane)
    {

        handler = new MenuHandler();

        pane = worldPane;

        farm = pane.getFarm();

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
//                Label l = new Label("no text input");
//                TextInputDialog td = new TextInputDialog("Enter here");
//                td.setHeaderText("How many Ants do you want");
//                td.showAndWait();
//               // set the text of the label
//                l.setText(td.getEditor().getText());
                pane.runSimulation();
                isRunning = true;

//                AntType digger = new AntType(diggAnt.getAntTile(), diggAnt.getLocX(), diggAnt.getLocY(), diggAnt.getPlaySpeed(),diggAnt.getDiggerScreen());
//                AntType worker = new AntType(workingAnt.getAntTile(), workingAnt.getLocX(), workingAnt.getLocY(), workingAnt.getPlaySpeed(),workingAnt.getDiggerScreen());
//                farm.add(digger);
//                farm.add(worker);


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
                    farm.load(status, farm.getScreen(), pane.getAnt());
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

                    pane.getFarm().setPlayspeed(100);
            }
        }
    }
}