package main;

import java.io.BufferedWriter;
import java.io.*;
import java.util.Random;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class AntFarm {
    private static int antLocX;
    private static int antLocY;

    public static void main(String[] args) {
        Tile[][] screen = initialize();
        printScreen(screen);
        moveRandom(screen);
        printScreen(screen);
    }

    private static Tile[][] initialize() {
        int i;
        Tile[][] screen = new Tile[100][100];
        for (int j = 0; j < 100; j++) {
            for (i = 0; i < 10; i++) {
                screen[i][j] = Tile.S;
            }
            for (int k = i; k < 100; k++) {
                screen[k][j] = Tile.D;
            }
        }

        this.antLocX = 50;
        this.antLocY = 50;
        this.playspeed = 4000;
        screen[antLocX][antLocY] = Tile.A;
	TimerTask task = new TimerTask() {
            @Override
            public void run() {
                moveRandom(screen);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, new Date(), playspeed);
    }

    public int getAntLocX() {
        return antLocX;
    }

    public void setAntLocX(int antLocX) {
        this.antLocX = antLocX;
    }


    public int getAntLocY() {
        return antLocY;

    }

    private static void moveRandom(Tile[][] screen) {
        Random rn = new Random();
        int direction = rn.nextInt(4) + 1;

//         while (isSafeDirection(direction, antLocX, antLocY) == false)
//             direction = rn.nextInt(4) + 1;

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

//    private static boolean isSafeDirection(int direction, int antLocX, int antLocY)
//     {
//         int locX = antLocX;
//         int locY = antLocY;
//         switch (direction) {
//             case 1:
//                 locX = locX - 1;
//                 if (isOutOfBounds(locX, locY))
//                     return false;
//                 else
//                     return true;
//             case 2:
//                 locY = locY + 1;
//                 if (isOutOfBounds(locX, locY))
//                     return false;
//                 else
//                     return true;
//             case 3:
//                 locX = locX + 1;
//                 if (isOutOfBounds(locX, locY))
//                     return false;
//                 else
//                     return true;
//             case 4:
//                 locY = locY - 1;
//                 if (isOutOfBounds(locX, locY))
//                     return false;
//                 else
//                     return true;
//             default:
//                 return false;
//         }
//     }

//     public static boolean isOutOfBounds(int antLocX, int antLocY) {

//         if (antLocX < 0 || antLocX > 100)
//             return true;

//         if (antLocY < 0 || antLocY > 100)
//             return true;

//         return false;
//     }

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

    //TODO Combine with constructor above
    public void load(String filename, Tile[][] screen) {
        try {

            Scanner fileReader = new Scanner(new File(filename));
            for (int r = 0; r < 100; r++) {
                for (int c = 0; c < 100; c++) {
                    String t = fileReader.nextLine();
                    screen[r][c] = Tile.valueOf(t);
                    //Loads to a local variable and does nothing
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
