package main;

import java.util.Random;

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
        screen[50][50] = Tile.A;
        antLocX = 50;
        antLocY = 50;
        return screen;
    }

    private static void moveRandom(Tile[][] screen) {
        Random rn = new Random();
        int direction = rn.nextInt(4) + 1;
        switch (direction) {
            case 1:
                screen[antLocX][antLocY] = Tile.T;
                antLocX = antLocX - 1;
                screen[antLocX][antLocY] = Tile.A;
                break;
            case 2:
                screen[antLocX][antLocY] = Tile.T;
                antLocY = antLocY + 1;
                screen[antLocX][antLocY] = Tile.A;
                break;
            case 3:
                screen[antLocX][antLocY] = Tile.T;
                antLocX = antLocX + 1;
                screen[antLocX][antLocY] = Tile.A;
                break;
            case 4:
                screen[antLocX][antLocY] = Tile.T;
                antLocY = antLocY - 1;
                screen[antLocX][antLocY] = Tile.A;
                break;
        }
    }

    private static void printScreen(Tile[][] screen){
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
}
