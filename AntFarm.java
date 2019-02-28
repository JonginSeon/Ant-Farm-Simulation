package main;

import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;


public class AntFarm {

    private int antLocX;

    private int antLocY;

    private Tile[][] screen;

    private int playspeed;

    public AntFarm() {
        super();
        screen = new Tile[100][100];
        int rs;
        for (int c = 0; c < 100; c++) {

            for (rs = 0; rs < 10; rs++) {
                screen[rs][c] = Tile.S;
            }

            for (int rd = rs; rd < 100; rd++) {
                screen[rd][c] = Tile.D;
            }
        }

        this.antLocX = 50;
        this.antLocY = 50;
        this.playspeed = 10;
        screen[antLocX][antLocY] = Tile.A;
    }

    //    public AntFarm(int antLocX, int antLocY)
    //    {
    //        super();
    //        this.antLocX = antLocX;
    //        this.antLocY = antLocY;
    //    }

    //    public AntFarm(int antLocX)
    //    {
    //        super();
    //        this.antLocX = antLocX;
    //    }
    //
    //    public AntFarm(int antLocY){
    //        super();
    //        this.antLocY = antLocY;
    //    }

    //public static void main(String[] args) {

    //Tile[][] screen = initialize();

    // printScreen(screen);

    //moveRandom(screen);

    // printScreen(screen);

    // }


    //    private static Tile[][] initialize() {
    //        for (int j = 0; j < 100; j++) {
    //
    //                for (i = 0; i < 10; i++) {
    //
    //                    screen[i][j] = Tile.S;
    //
    //                }
    //
    //                for (int k = i; k < 100; k++) {
    //
    //                    screen[k][j] = Tile.D;
    //
    //                }
    //
    //        }
    //
    //        screen[50][50] = Tile.A;
    //
    //        antLocX = 50;
    //
    //        antLocY = 50;
    //
    //        return screen;
    //
    //    }


    public int getAntLocX() {
        return antLocX;
    }

    public void setAntLocX(int antLocX) {
        this.antLocX = antLocX;
    }


    public int getAntLocY() {
        return antLocY;
    }

    public void setAntLocY(int antLocY) {
        this.antLocY = antLocY;
    }

    public int getPlayspeed() {
        return playspeed;
    }

    public void setPlayspeed(int playspeed) {
        this.playspeed = playspeed;
    }


    private void moveRandom(Tile[][] screen) {

        Random rn = new Random();

        int direction = rn.nextInt(4) + 1;

        switch (direction) {

            case 1:

		if (antOutOfBounds(antLocX - 1, antLocY, screen)) {
			
			moveRandom(screen);

			break;

		}

                screen[antLocX][antLocY] = Tile.T;

                antLocX = antLocX - 1;

                screen[antLocX][antLocY] = Tile.A;

                break;

            case 2:

		if (antOutOfBounds(antLocX, antLocY + 1, screen)) {
			
			moveRandom(screen);

			break;

		}

                screen[antLocX][antLocY] = Tile.T;

                antLocY = antLocY + 1;

                screen[antLocX][antLocY] = Tile.A;

                break;

            case 3:

		if (antOutOfBounds(antLocX + 1, antLocY, screen)) {
			
			moveRandom(screen);

			break;

		}

                screen[antLocX][antLocY] = Tile.T;

                antLocX = antLocX + 1;

                screen[antLocX][antLocY] = Tile.A;

                break;

            case 4:

		if (antOutOfBounds(antLocX, antLocY - 1, screen)) {
			
			moveRandom(screen);

			break;

		}

                screen[antLocX][antLocY] = Tile.T;

                antLocY = antLocY - 1;

                screen[antLocX][antLocY] = Tile.A;

                break;

        }

    }


    private static void printScreen(Tile[][] screen) {

        for (int i = 0; i < 100; i++) {

            for (int j = 0; j < 100; j++) {

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

    public boolean antOutOfBounds(int antLocX, int antLocY, Tile[][] screen)
    {
        if(antLocX < 0 || antLocX > screen.length)
        {
            return true;
        }
        if(antLocY < 0 || antLocY > screen.length)
        {
            return true;
        }
	if(screen[antLocX][antLocY] == Tile.S)
	{
	    return true;
	}
        return false;
    }


    public void save(Tile[][] screen) {
        String fileName = "Saved Game";
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int r = 0; r < screen.length; r++) {
            for (int c = 0; c < screen.length; c++) {
                out.println(screen[r][c].name());
            }
        }
        out.close();
    }

    public void load(String filename) {
        try {
            Scanner fileReader = new Scanner(new File(filename));
            for (int r = 0; r < screen.length; r++) {
                for (int c = 0; c < screen.length; c++) {
                    String t = fileReader.nextLine();
                    screen[r][c] = Tile.valueOf(t);

                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ;
    }


}