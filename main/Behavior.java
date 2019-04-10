package main;

import java.util.Random;

public class Behavior {

    public void moveRandom(Ant ant, Tile[][] screen) {
        Random rn = new Random();
        int direction = rn.nextInt(4) + 1;
        switch (direction) {
            case 1:
                ant.setLocX(ant.getLocX() - 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() + 1);
                    moveRandom(ant, screen);
                    break;
                }
                screen[ant.getLocX() + 1][ant.getLocY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 2:
                ant.setLocY(ant.getLocY() + 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocY(ant.getLocY() - 1);
                    moveRandom(ant, screen);
                    break;
                }
                screen[ant.getLocX()][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 3:
                ant.setLocX(ant.getLocX() + 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() - 1);
                    moveRandom(ant, screen);
                    break;
                }
                screen[ant.getLocX() - 1][ant.getLocY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 4:
                ant.setLocY(ant.getLocY() - 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocY(ant.getLocY() + 1);
                    moveRandom(ant, screen);
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
                    moveRandom(ant, screen);
                    break;
                }
                screen[ant.getLocX() + 1][ant.getLocY() + 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.W;
                break;

            case 2:
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() + 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() - 1);
                    moveRandom(ant, screen);
                    break;
                }
                screen[ant.getLocX() + 1][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.W;
                break;

            case 3:
                ant.setLocX(ant.getLocX() + 1);
                ant.setLocY(ant.getLocY() - 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() - 1);
                    ant.setLocY(ant.getLocY() + 1);
                    moveRandom(ant, screen);
                    break;
                }
                screen[ant.getLocX() - 1][ant.getLocY() + 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.W;
                break;

            case 4:
                ant.setLocX(ant.getLocX() + 1);
                ant.setLocY(ant.getLocY() + 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() - 1);
                    ant.setLocY(ant.getLocY() - 1);
                    moveRandom(ant, screen);
                    break;
                }
                screen[ant.getLocX() - 1][ant.getLocY() - 1] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.W;
                break;

            default:
                break;
        }
    }

    private boolean antOutOfBounds(Ant ant, Tile[][] screen) {
//        if(getLocX()<10 || getLocX()>12) return true;
//
//        if(getLocY()<50 || getLocY()>52)  return true;
//
//        if(screen[getLocX()][getLocY()] == Tile.S) return true;
//
//        else return false;
        if (ant.getLocX() < 0 || ant.getLocX() > 100) //Used to be 100
        {
            return true;
        }
        if (ant.getLocY() < 0 || ant.getLocY() > 100) {
            return true;
        }
        if (screen[ant.getLocX()][ant.getLocY()] == Tile.S) {
            return true;
        }
        return screen[ant.getLocX()][ant.getLocY()] == Tile.Q || screen[ant.getLocX()][ant.getLocY()] == Tile.G || screen[ant.getLocX()][ant.getLocY()] == Tile.W;
    }
}
