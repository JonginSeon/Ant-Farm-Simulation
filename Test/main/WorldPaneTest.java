package main;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class WorldPaneTest extends ApplicationTest {
    private static Tile[][] screen;
    private Button[][] world;
private JButton button = new JButton();
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root, 1000, 950));
        primaryStage.show();
        primaryStage.toFront();
    }


    @Test
    public void createWorld() {
        AntFarm a = new AntFarm();
        WorldPane t = new WorldPane();
        TilePane tilePane = new TilePane();

        WorldPane.ButtonHandler handler = t.new ButtonHandler();
        Button btn;
        btn = new Button();
        t.createWorld(tilePane, handler);


        screen = new Tile[100][100];
        int i;
        for (int j = 0; j < 100; j++) {
            for (i = 0; i < 10; i++) {
                screen[i][j] = Tile.S;
            }
            for (int k = i; k < 100; k++) {
                screen[k][j] = Tile.D;
            }
        }

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

        t.createWorld(tilePane, handler);
        assertEquals(screen[12][20],Tile.D);
        a.antOutOfBounds(12,20);
        screen[12][20]=Tile.A;

//        for (int r = 0; r < 100; r++) {
//            for (int c = 0; c < 100; c++) {
//                world[r][c].setOnAction(handler);
//            }
//        }

        this.world[12][20] = btn;

        world[12][20].setDefaultButton(true);
        if(world[12][20].isPressed()){
            world[12][20].setStyle("-fx-background-color: Black");
            System.out.println("Pass000");
        }
        assertEquals(screen[12][20],Tile.A);

        //this.world[12][20].addEventHandler(ActionEvent.setOnMouseCliked(),(handler));


        //System.out.println(world[12][20].isPressed());




    }

    @Test
    public void testButtonHandler(){
        AntFarm a = new AntFarm();
        WorldPane t = new WorldPane();
        TilePane tilePane = new TilePane();

        WorldPane.ButtonHandler handler = t.new ButtonHandler();

    }
    @After
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void updateWorld() throws IllegalStateException {
       // AntGui a= new AntGui();

        WorldPane worldPane = new WorldPane();

        screen = new Tile[100][100];
        int i;
        for (int j = 0; j < 100; j++) {
            for (i = 0; i < 10; i++) {
                screen[i][j] = Tile.S;
            }
            for (int k = i; k < 100; k++) {
                screen[k][j] = Tile.D;
            }
        }

        worldPane.updateWorld(screen);



    }

    @Test
    public void resetWorld() {
        AntFarm t = new AntFarm();
        WorldPane a = new WorldPane();
        screen = new Tile[100][100];
        int i;
        for (int j = 0; j < 100; j++) {
            for (i = 0; i < 10; i++) {
                screen[i][j] = Tile.S;
            }
            for (int k = i; k < 100; k++) {
                screen[k][j] = Tile.D;
                if(screen[20][20]==Tile.D){
                    screen[20][20]=Tile.A;
                }
            }
        }
        a.updateWorld(screen);
        a.resetWorld();
        assertNotEquals(a.getFarm().getScreen(),screen);

    }

    @Test
    public void runSimulation() {
        WorldPane a = new WorldPane();
        System.out.println("Pass");
        a.runSimulation();
        a.runSimulation();

        a.stopSimulation();

        assertNotEquals(a.getFarm().getScreen(), screen);

        }
    }