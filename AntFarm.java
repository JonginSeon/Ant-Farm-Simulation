package main;



import java.io.BufferedWriter;

import java.io.*;

import java.util.Random;

import java.util.Scanner;



public class AntFarm {

    private static Tile[][] screen;

    private int playspeed;



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



    public Tile[][] getScreen() {

        return screen;

    }



    public int getPlayspeed() {

        return playspeed;

    }



    public void setPlayspeed(int playspeed) {

        this.playspeed = playspeed;

    }



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



    private void printScreen(Tile[][] screen) {

        for (int i = 0; i < screen.length; i++) {

            for (int j = 0; j < screen.length; j++) {

                switch (screen[i][j]) {

                    case A:

                        System.out.print('A');

                        break;

                    case D:

                        System.out.print('D');

                        break;

                    case S:

                        System.out.print('S');

                        break;

                    case T:

                        System.out.print('T');

                        break;

                }

                if (j == 99) System.out.println();

            }

        }



        System.out.println();



    }



    public boolean antOutOfBounds(Ant ant) {

        if (ant.getLocX() < 0 || ant.getLocX() >= screen.length) //Used to be 100

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



    public void save(Tile[][] screen,File file) {
        //String fileName = "Saved Game";
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



    //TODO Combine with constructor above

    public void load(File file, Tile[][] screen) {
        try {
            Scanner fileReader = new Scanner(file);
            for (int r = 0; r < screen.length; r++) {
                for (int c = 0; c < screen.length; c++) {
                    String t = fileReader.nextLine();
                    if(t.equalsIgnoreCase("A"))
                    {
                        System.out.println("row " + r);
                        System.out.println("col " + c);
                        //antLocX = r;
                        //antLocY = c;
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