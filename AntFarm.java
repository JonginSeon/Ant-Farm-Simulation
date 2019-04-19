package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * This class creates and manages an array of Tiles which are interpreted
 * by the WorldPane and WorldMenuBar classes to create the visible gui.
 * @author Justin, Christian, Jongin, Elijah
 * @version 4/17/2019
 */
public class AntFarm {
    /** An array of tiles representing ants and the world environment. */
    private Tile[][] screen;

    /** The time in milliseconds between each WorldPane update. */
    private int playspeed;

    /** The size of the length and width of the tile array. */
    private static int size = 100;

    /**
     * Creates a new AntFarm with a 100 x 100 Tile array. Rows 1-10 of the array
     * are set to Tile "S" (Soil), the remainder are set to Tile "D" (Dirt).
     * After this, a random assortment of Tiles are set to Tile "F" (Food).
     */
    public AntFarm() {

        screen = new Tile[size][size];
        Random rn = new Random();

        int i;
        int ranK = 0;
        int ranJ = 0;

        for (int j = 0; j < size; j++) {

            for (i = 0; i < 10; i++) {
                screen[i][j] = Tile.S;

            }
            for (int k = i; k < size; k++) {
                screen[k][j] = Tile.D;

            }
        }
        playspeed = 500;

        for (int n = 0; n < 120; n++) {
            ranK = rn.nextInt(size) + 10;
            ranJ = rn.nextInt(size) + 1;
            if (ranK < size && ranJ < size) {
                screen[ranK][ranJ] = Tile.F;
            }
        }

    }

    /**
     * Counts the amount of Food Tiles currently in the Tile Array.
     * @return The number of "F" Tiles
     */
    public int foodCounter() {
        int counter = 0;
        for (int j = 0; j < size; j++) {

            for (int i = 10; i < size; i++) {
                if (screen[i][j] == Tile.F) {
                    counter++;
                }
            }

        }
        return counter;
    }


    /**
     * Counts the amount of WorkingAnt Tiles currently in the Tile Array.
     * @param screen The array to be counted
     * @return The number of "W" Tiles
     */
    public int workingAntCounter(Tile[][] screen) {
        int counter = 0;
        for (int j = 0; j < size; j++) {

            for (int i = 10; i < size; i++) {
                if (screen[i][j] == Tile.W) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Counts the amount of DiggingAnt Tiles currently in the Tile Array.
     * @param screen The array to be counted
     * @return The number of "G" Tiles
     */
    public int diggingAntCounter(Tile[][] screen) {
        int counter = 0;
        for (int j = 0; j < size; j++) {

            for (int i = 10; i < size; i++) {
                if (screen[i][j] == Tile.G) {
                    counter++;
                }
            }

        }
        return counter;
    }

    /**
     * Counts the amount of Queen Tiles currently in the Tile Array.
     * @param screen The array to be counted
     * @return The number of "Q" Tiles
     */
    public int queenCounter(Tile[][] screen) {
        int counter = 0;
        for (int j = 0; j < size; j++) {

            for (int i = 10; i < size; i++) {
                if (screen[i][j] == Tile.Q) {
                    counter++;
                }
            }

        }
        return counter;
    }

    /**
     * Counts the amount of King Tiles currently in the Tile Array.
     * @param screen The array to be counted
     * @return The number of "K" Tiles
     */
    public int kingCounter(Tile[][] screen) {
        int counter = 0;
        for (int j = 0; j < size; j++) {

            for (int i = 10; i < size; i++) {
                if (screen[i][j] == Tile.K) {
                    counter++;
                }
            }

        }
        return counter;
    }

    /**
     * Gets the current Tile Array.
     * @return A 100 x 100 Tile Array
     */
    public Tile[][] getScreen() {
        return screen;
    }

    /**
     * Gets the time current play speed.
     * @return The play speed
     */
    public int getPlayspeed() {
        return playspeed;
    }

    /**
     * Sets the value property play speed.
     * @param playspeed The new play speed
     */
    public void setPlayspeed(int playspeed) {
        this.playspeed = playspeed;
    }

    /**
     * Saves the current state of the Tile array by writing out letters
     * that each represent a specific Tile type into a text document.
     * @param screen The current Tile array
     * @param file The text document
     */
    public void save(Tile[][] screen, File file) {

        PrintWriter out = null;

        try {

            out = new PrintWriter(file);

            for (int r = 0; r < screen.length; r++) {

                for (int c = 0; c < screen.length; c++) {

                    out.println(screen[r][c].name());

                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method updates the current Tile array by
     * interpreting a series of letters from a text document. Once
     * done, it uses the a specified ants location-coordinates to
     * place it in the right position in the Tile array.
     * @param file A text document
     * @param screen The current Tile array
     * @param ants All of the Ants currently in play
     */
    public void load(File file, Tile[][] screen, Ant[] ants) {
        try {
            Scanner fileReader = new Scanner(file);
            int i = 1;
            for (int r = 0; r < screen.length; r++) {

                for (int c = 0; c < screen.length; c++) {

                    String t = fileReader.nextLine();

                    if (t.equalsIgnoreCase("Q")) {
                        Queen queen = new Queen();
                        ants[0] = queen;
                        ants[0].setLocX(r);
                        queen.setNestCenterX();
                        ants[0].setLocY(c);
                        queen.setNestCenterY();
                    }

                    if (t.equalsIgnoreCase("K")) {
                        ants[i] = new King(r, c);
                        i++;
                    }

                    if (t.equalsIgnoreCase("W")) {
                        ants[i] = new WorkingAnt(r, c);
                        i++;
                    }

                    if (t.equalsIgnoreCase("G")) {
                        ants[i] = new DiggingAnt(r, c);
                        i++;
                    }

                    screen[r][c] = Tile.valueOf(t);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
