package main;



import java.io.BufferedWriter;

import java.io.*;

import java.util.Random;

import java.util.Scanner;



public class AntFarm {

    private static Tile[][] screen;

    private int antLocX;

    private int antLocY;

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



        antLocX = 10;

        antLocY = 50;

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



    public void moveRandom() {

        Random rn = new Random();

        int direction = rn.nextInt(4) + 1;



//         while (isSafeDirection(direction, antLocX, antLocY) == false)

//             direction = rn.nextInt(4) + 1;



        switch (direction) {

            case 1:



                if (antOutOfBounds(antLocX - 1, antLocY)) {
                    moveRandom();
                    break;
                }



                screen[antLocX][antLocY] = Tile.T;

                antLocX = antLocX - 1;

                screen[antLocX][antLocY] = Tile.A;

                break;



            case 2:

                if (antOutOfBounds(antLocX, antLocY + 1)) {



                    moveRandom();



                    break;



                }

                screen[antLocX][antLocY] = Tile.T;

                antLocY = antLocY + 1;

                screen[antLocX][antLocY] = Tile.A;

                break;



            case 3:

                if (antOutOfBounds(antLocX + 1, antLocY)) {



                    moveRandom();



                    break;



                }

                screen[antLocX][antLocY] = Tile.T;

                antLocX = antLocX + 1;

                screen[antLocX][antLocY] = Tile.A;

                break;



            case 4:

                if (antOutOfBounds(antLocX, antLocY - 1)) {

                    moveRandom();

                    break;

                }



                screen[antLocX][antLocY] = Tile.T;

                antLocY = antLocY - 1;

                screen[antLocX][antLocY] = Tile.A;

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



    public boolean antOutOfBounds(int antLocX, int antLocY) {

        if (antLocX < 0 || antLocX >= screen.length) //Used to be 100

        {

            return true;

        }

        if (antLocY < 0 || antLocY >= screen.length) {

            return true;

        }

        if (screen[antLocX][antLocY] == Tile.S)

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
                        antLocX = r;
                        antLocY = c;
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