package main;

import java.util.Random;

public class Behavior {
    Random rn = new Random();

    public void moveRandomCross(Ant ant, Tile[][] screen) {
        int direction = rn.nextInt(4) + 1;
        switch (direction) {
            case 1:
                ant.setLocX(ant.getLocX() - 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() + 1);
                    moveRandomCross(ant, screen);
                    break;
                }
                screen[ant.getLocX() + 1][ant.getLocY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 2:
                ant.setLocY(ant.getLocY() + 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocY(ant.getLocY() - 1);
                    moveRandomCross(ant, screen);
                    break;
                }
                screen[ant.getLocX()][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 3:
                ant.setLocX(ant.getLocX() + 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() - 1);
                    moveRandomCross(ant, screen);
                    break;
                }
                screen[ant.getLocX() - 1][ant.getLocY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 4:
                ant.setLocY(ant.getLocY() - 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocY(ant.getLocY() + 1);
                    moveRandomCross(ant, screen);
                    break;
                }
                screen[ant.getLocX()][ant.getLocY() + 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            default:
                break;
        }
    }

    public void moveRandomDiag(Ant ant, Tile[][] screen) {
        Random rn = new Random();
        int direction = rn.nextInt(4) + 1;
        switch (direction) {
            case 1:
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() - 1);
                if (antOutOfBounds(ant, screen)){
                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() + 1);
                    moveRandomDiag(ant, screen);
                    break;
                }
                screen[ant.getLocX() + 1][ant.getLocY() + 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 2:
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() + 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() - 1);
                    moveRandomDiag(ant, screen);
                    break;
                }
                screen[ant.getLocX() + 1][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 3:
                ant.setLocX(ant.getLocX() + 1);
                ant.setLocY(ant.getLocY() - 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() - 1);
                    ant.setLocY(ant.getLocY() + 1);
                    moveRandomDiag(ant, screen);
                    break;
                }
                screen[ant.getLocX() - 1][ant.getLocY() + 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 4:
                ant.setLocX(ant.getLocX() + 1);
                ant.setLocY(ant.getLocY() + 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() - 1);
                    ant.setLocY(ant.getLocY() - 1);
                    moveRandomDiag(ant, screen);
                    break;
                }
                screen[ant.getLocX() - 1][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            default:
                break;
        }
    }

    public void moveRandom(Ant ant, Tile[][] screen) {
        Random rn = new Random();
        int direction = rn.nextInt(2) + 1;
        switch (direction) {
            case 1:
                moveRandomCross(ant, screen);
                break;

            case 2:
                moveRandomDiag(ant, screen);
                break;
        }
    }


    private boolean antOutOfBounds(Ant ant, Tile[][] screen) {

        if(ant.getAntTile() == Tile.Q) {
            if (ant.getLocX() < 10 || ant.getLocX() > 12) return true;

            if (ant.getLocY() < 50 || ant.getLocY() > 52) return true;

            if (screen[ant.getLocX()][ant.getLocY()] == Tile.S) return true;

            else return false;
        }

        else{
        if (ant.getLocX() < 0 || ant.getLocX() > 50) //Used to be 100
        {
            return true;
        }
        if (ant.getLocY() < 0 || ant.getLocY() > 50) {
            return true;
        }
        if (screen[ant.getLocX()][ant.getLocY()] == Tile.S) {
            return true;
        }
        return screen[ant.getLocX()][ant.getLocY()] == Tile.Q || screen[ant.getLocX()][ant.getLocY()] == Tile.G || screen[ant.getLocX()][ant.getLocY()] == Tile.W;
    }
    }

    public void foodGenerator( int n, Tile[][] screen){
        Random rn = new Random();
        for(int i = 0; i<n; i++) {
            int x = rn.nextInt(89) + 10;
            int y = rn.nextInt(99) + 1;
            System.out.println(x);
            //System.out.println(y);
            if (x < 100 && y < 100) {
                if (screen[x][y] == Tile.F) foodGenerator(i, screen);
                else screen[x][y] = Tile.F;
            }
        }
    }
}

