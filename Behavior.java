package main;

import java.util.Random;
public class Behavior {
WorldPane   pane = new WorldPane();
    Random rn = new Random();
int foodObtained;
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
                isFood(ant,screen);
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
                isFood(ant,screen);
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
                isFood(ant,screen);
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
                isFood(ant,screen);
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;
        }
    }

    public void moveRandomDiag(Ant ant, Tile[][] screen) {
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
                isFood(ant,screen);
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 2:
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() + 1);
                if (moveBackNE(ant, screen)) break;

                screen[ant.getLocX() + 1][ant.getLocY() - 1] = Tile.T;
                isFood(ant,screen);
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
                isFood(ant,screen);
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 4:
                ant.setLocX(ant.getLocX() + 1);
                ant.setLocY(ant.getLocY() + 1);
                if (moveBackNW(ant, screen)) break;

                screen[ant.getLocX() - 1][ant.getLocY() - 1] = Tile.T;
                isFood(ant,screen);
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;
        }
    }

    public void moveRandom(Ant ant, Tile[][] screen) {
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

    public void digToBottom(Queen ant, Tile[][] screen) {
        if (ant.getLocX() < 70) {
            int direction = rn.nextInt(3) + 1;
            switch (direction) {
                case 1:
                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() - 1);
                    if (moveBackNE(ant, screen)) break;

                    screen[ant.getLocX() - 1][ant.getLocY() + 1] = Tile.T;
                    isFood(ant,screen);
                    screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                    break;

                case 2:
                    ant.setLocX(ant.getLocX() + 1);
                    if (antOutOfBounds(ant, screen)) {
                        ant.setLocX(ant.getLocX() - 1);
                        moveRandomCross(ant, screen);
                        break;
                    }

                    screen[ant.getLocX() - 1][ant.getLocY()] = Tile.T;
                    isFood(ant,screen);
                    screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                    break;

                case 3:
                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() + 1);
                    if (moveBackNW(ant, screen)) break;

                    screen[ant.getLocX() - 1][ant.getLocY() - 1] = Tile.T;
                    isFood(ant,screen);
                    screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                    break;
            }
        }
        else if (ant.getNestCenterX() == -1) {
            ant.setNestCenterX();
            ant.setNestCenterY();
            buildHive(ant, screen);
        }
        else buildHive(ant, screen);
    }

    private void buildHive(Queen ant, Tile[][] screen) {
        int prevX;
        int prevY;
        if (ant.getNestCenterX() == ant.getLocX() && ant.getNestCenterY() == ant.getLocY()) {
            if (screen[ant.getLocX()][ant.getLocY() - 1] == Tile.D) {
                ant.setLocY(ant.getLocY() - 1);

                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                isFood(ant,screen);
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            }
            else if (screen[ant.getLocX() - 1][ant.getLocY() - 1] == Tile.D) {
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() - 1);


                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                isFood(ant,screen);
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            }
            else if (screen[ant.getLocX() - 1][ant.getLocY()] == Tile.D) {
                ant.setLocX(ant.getLocX() - 1);

                isFood(ant,screen);
                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            }
            else if (screen[ant.getLocX() - 1][ant.getLocY() + 1] == Tile.D) {
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() + 1);

                isFood(ant,screen);
                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            }
            else if (screen[ant.getLocX()][ant.getLocY() + 1] == Tile.D)  {
                ant.setLocY(ant.getLocY() + 1);

                isFood(ant,screen);
                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            }
        }
        else {
            prevX = ant.getLocX();
            prevY = ant.getLocY();
            ant.setLocX(ant.getNestCenterX());
            ant.setLocY(ant.getNestCenterY());
            isFood(ant,screen);
            screen[prevX][prevY] = Tile.T;
            screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
        }
    }

    private boolean moveBackNW(Ant ant, Tile[][] screen) {
        if (antOutOfBounds(ant, screen)) {
            ant.setLocX(ant.getLocX() - 1);
            ant.setLocY(ant.getLocY() - 1);
            moveRandomDiag(ant, screen);
            return true;
        }
        return false;
    }

    private boolean moveBackNE(Ant ant, Tile[][] screen) {
        if (antOutOfBounds(ant, screen)) {
            ant.setLocX(ant.getLocX() - 1);
            ant.setLocY(ant.getLocY() + 1);
            moveRandomDiag(ant, screen);
            return true;
        }
        return false;
    }


    private boolean antOutOfBounds(Ant ant, Tile[][] screen) {
        if (ant.getLocX() < 0 || ant.getLocX() > 99) //Used to be 100
        {
            return true;
        }
        if (ant.getLocY() < 0 || ant.getLocY() > 99) {
            return true;
        }
        if (screen[ant.getLocX()][ant.getLocY()] == Tile.S) {
            return true;
        }
        return screen[ant.getLocX()][ant.getLocY()] == Tile.Q || screen[ant.getLocX()][ant.getLocY()] == Tile.G || screen[ant.getLocX()][ant.getLocY()] == Tile.W;

    }

    public void foodGenerator( Tile[][] screen){
        Random rn = new Random();
            int x = rn.nextInt(89) + 10;
            int y = rn.nextInt(99) + 1;

            if (x < 100 && y < 100) {
                if (screen[x][y] == Tile.F) foodGenerator(screen);
                else screen[x][y] = Tile.F;
            }
    }


    public int isFood(Ant ant, Tile[][] screen){
        if(screen[ant.getLocX()][ant.getLocY()]==Tile.F){
            this.foodObtained++;
        }
        return this.foodObtained;
    }

    public int getFoodObtained(){

        return foodObtained;

    }
}

