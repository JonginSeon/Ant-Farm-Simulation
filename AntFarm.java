package main;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * This class creates and manages an array of Tiles which are interpreted
 * by the WorldPane and WorldMenuBar classes to create the visible gui.
 * @author Justin and Christian
 * @version 4/06/2019
 */
public class AntFarm {

    private static Tile[][] screen; /** A Tile array that represent the components of an ant farm*/
    private int playspeed; /** The speed, in milliseconds, between actions */

    /**
     * The standard constructor. It creates a 100 x 100 array of Tiles and
     * sets the playspeed to 500 milliseconds per action.
     */
    public AntFarm() {
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
        playspeed = 500;
    }

    /**
     * @return screen
     */
    public Tile[][] getScreen() {
        return screen;
    }

    /**
     * @return playspeed
     */
    public int getPlayspeed() {
        return playspeed;
    }

    /**
     * Changes the play speed
     * @param playspeed The time between actions
     */
    public void setPlayspeed(int playspeed) {
        this.playspeed = playspeed;
    }

    /**
     * Changes the position of a selected ant by one spot
     * vertically or horizontally in the Tile array.
     * @param ant An object of the ant class whose movement will be directed
     */
    public void moveRandom(Ant ant) {
        Random rn = new Random();
        int direction = rn.nextInt(4) + 1;
        switch (direction) {

            case 1:

                ant.setLocX(ant.getLocX() - 1);

                if (antOutOfBounds(ant)) {

                    ant.setLocX(ant.getLocX() + 1);
                    moveRandom(ant);

                    break;
                }

                screen[ant.getLocX() + 1][ant.getLocY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.A;
                break;

            case 2:

                ant.setLocY(ant.getLocY() + 1);

                if (antOutOfBounds(ant)) {

                    ant.setLocY(ant.getLocY() - 1);
                    moveRandom(ant);

                    break;
                }

                screen[ant.getLocX()][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.A;
                break;

            case 3:

                ant.setLocX(ant.getLocX() + 1);

                if (antOutOfBounds(ant)) {

                    ant.setLocX(ant.getLocX() - 1);
                    moveRandom(ant);

                    break;

                }

                screen[ant.getLocX() - 1][ant.getLocY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.A;
                break;

            case 4:

                ant.setLocY(ant.getLocY() - 1);

                if (antOutOfBounds(ant)) {

                    ant.setLocY(ant.getLocY() + 1);
                    moveRandom(ant);

                    break;
                }

                screen[ant.getLocX()][ant.getLocY() + 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.A;
                break;

            default:
                break;
        }

    }

    /**
     * Changes the position of a selected ant diagonally
     * in the Tile array.
     * @param ant An object of the ant class whose movement will be directed
     */
    public void moveRandomDiag(Ant ant) {
        Random rn = new Random();
        int direction = rn.nextInt(4) + 1;

        switch (direction) {
            case 1:

                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() - 1);

                if (antOutOfBounds(ant)) {

                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() + 1);
                    moveRandom(ant);

                    break;
                }

                screen[ant.getLocX() + 1][ant.getLocY() + 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.A;
                break;

            case 2:

                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() + 1);

                if (antOutOfBounds(ant)) {

                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() - 1);
                    moveRandom(ant);

                    break;
                }

                screen[ant.getLocX() + 1][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.A;

                break;

            case 3:

                ant.setLocX(ant.getLocX() + 1);
                ant.setLocY(ant.getLocY() - 1);

                if (antOutOfBounds(ant)) {

                    ant.setLocX(ant.getLocX() - 1);
                    ant.setLocY(ant.getLocY() + 1);
                    moveRandom(ant);

                    break;
                }

                screen[ant.getLocX() - 1][ant.getLocY() + 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.A;

                break;

            case 4:

                ant.setLocX(ant.getLocX() + 1);
                ant.setLocY(ant.getLocY() + 1);

                if (antOutOfBounds(ant)) {

                    ant.setLocX(ant.getLocX() - 1);
                    ant.setLocY(ant.getLocY() - 1);
                    moveRandom(ant);

                    break;
                }

                screen[ant.getLocX() - 1][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.A;
                break;

            default:
                break;
        }
    }

    /**
     * Tests whether an ants location-coordinates are within the range
     * allowed by the current Tile array
     * @param ant An object of the ant class whose position will be tested
     * @return True if the ant is out of bounds, False if it is not
     */
    public boolean antOutOfBounds(Ant ant) {

        if (ant.getLocX() < 0 || ant.getLocX() >= screen.length)
        {
            return true;
        }
        if (ant.getLocY() < 0 || ant.getLocY() >= screen.length) {
            return true;
        }
        if (screen[ant.getLocX()][ant.getLocY()] == Tile.S)
            return true;
        else
            return false;
    }

    /**
     * Saves the current state of the Tile array by writing out letters
     * that each represent a specific Tile type into a text document.
     * The letters that represent each Tile type are:
     * S = Sky, D = Dirt, T = Tunnel, A = Ant
     * @param screen The current Tile array
     * @param file A text document
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
     * This method creates updates the current Tile array by
     * interpreting a series of letters from a text document. Once
     * done, it uses the a specified ants location-coordinates to
     * place it in the right position in the Tile array.
     * @param file A text document
     * @param screen The current Tile array
     * @param ant Any specific ant
     */
    public void load(File file, Tile[][] screen, Ant ant) {
        try {

            Scanner fileReader = new Scanner(file);
            for (int r = 0; r < screen.length; r++) {
                for (int c = 0; c < screen.length; c++) {

                    String t = fileReader.nextLine();

                    if(t.equalsIgnoreCase("A"))
                    {
                        System.out.println("row " + r);
                        System.out.println("col " + c);
                        ant.setLocX(r);
                        ant.setLocY(c);
                    }
                    screen[r][c] = Tile.valueOf(t);
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}