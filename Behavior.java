package main;

import java.util.Random;

/**
 * This class handles the movements and behaviors of each different Ant Type.
 * It also controls the generation of food and the effects of an Ant touching
 * food tiles.
 */
public class Behavior { //TODO Javadocs are NOT DONE for moveRandom methods!

    Random rn = new Random();
    int foodObtained;

    /**
     * Makes an Ant randomly shift position to an adjacent position in the world.
     * There are
     *
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     */
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

    /**
     * Makes an Ant randomly shift position to an adjacent position.
     * There are four possible movements: up, down, left, and right.
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     */
    public void moveRandomCross(Ant ant, Tile[][] screen) {

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

    /**
     * Makes an Ant randomly shift position to an adjacent position in the world.
     * There are four possible movements: up-left, up-right, down-left, and down-right
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     */
    public void moveRandomDiag(Ant ant, Tile[][] screen) {
        int direction = rn.nextInt(4) + 1;
        switch (direction) {
            case 1:
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() - 1);
                if (antOutOfBounds(ant, screen)) {
                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() + 1);
                    moveRandomDiag(ant, screen);
                    break;
                }
                screen[ant.getLocX() + 1][ant.getLocY() + 1] = Tile.T;
                isFood(ant, screen);
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 2:
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() + 1);
                if (moveBackNE(ant, screen)) break;

                screen[ant.getLocX() + 1][ant.getLocY() - 1] = Tile.T;
                isFood(ant, screen);
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
                isFood(ant, screen);
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;

            case 4:
                ant.setLocX(ant.getLocX() + 1);
                ant.setLocY(ant.getLocY() + 1);
                if (moveBackNW(ant, screen)) break;

                screen[ant.getLocX() - 1][ant.getLocY() - 1] = Tile.T;
                isFood(ant, screen);
                screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                break;
        }
    }

    /**
     * Makes the ant move vertically down  in random horizontal
     * directions until it reaches row 70. At Row 70, the ant stops going down,
     * its current position is set as the location of the nest, and finally
     * buildHive() is called to create the nest.
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     */
    public void digToBottom(Queen ant, Tile[][] screen) {
        if (ant.getLocX() < 71) {
            int direction = rn.nextInt(3) + 1;
            switch (direction) {
                case 1:
                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() - 1);
                    if (moveBackNE(ant, screen)) break;

                    screen[ant.getLocX() - 1][ant.getLocY() + 1] = Tile.T;
                    isFood(ant, screen);
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
                    isFood(ant, screen);
                    screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                    break;

                case 3:
                    ant.setLocX(ant.getLocX() + 1);
                    ant.setLocY(ant.getLocY() + 1);
                    if (moveBackNW(ant, screen)) break;

                    screen[ant.getLocX() - 1][ant.getLocY() - 1] = Tile.T;
                    isFood(ant, screen);
                    screen[ant.getLocX()][ant.getLocY()] = ant.getAntTile();
                    break;
            }

        } else if (ant.getNestCenterX() == -1) {
            ant.setNestCenterX();
            ant.setNestCenterY();
            buildHive(ant, screen);
        } else buildHive(ant, screen);
    }

    /**
     * Makes an ant move a randomly move around its nest area, creating a small,
     * dug out area. From then on, new Ants will spawn in the nest area.
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     */
    private void buildHive(Queen ant, Tile[][] screen) {
        int prevX;
        int prevY;
        if (ant.getNestCenterX() == ant.getLocX() && ant.getNestCenterY() == ant.getLocY()) {
            if (screen[ant.getLocX()][ant.getLocY() - 1] == Tile.D) {
                ant.setLocY(ant.getLocY() - 1);

                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                isFood(ant, screen);
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            } else if (screen[ant.getLocX() - 1][ant.getLocY() - 1] == Tile.D) {
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() - 1);


                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                isFood(ant, screen);
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            } else if (screen[ant.getLocX() - 1][ant.getLocY()] == Tile.D) {
                ant.setLocX(ant.getLocX() - 1);

                isFood(ant, screen);
                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            } else if (screen[ant.getLocX() - 1][ant.getLocY() + 1] == Tile.D) {
                ant.setLocX(ant.getLocX() - 1);
                ant.setLocY(ant.getLocY() + 1);

                isFood(ant, screen);
                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            } else if (screen[ant.getLocX()][ant.getLocY() + 1] == Tile.D) {
                ant.setLocY(ant.getLocY() + 1);

                isFood(ant, screen);
                screen[ant.getNestCenterX()][ant.getNestCenterY()] = Tile.T;
                screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
            }
        } else {
            prevX = ant.getLocX();
            prevY = ant.getLocY();
            ant.setLocX(ant.getNestCenterX());
            ant.setLocY(ant.getNestCenterY());
            isFood(ant, screen);
            screen[prevX][prevY] = Tile.T;
            screen[ant.getLocX()][ant.getLocY()] = Tile.Q;
        }
    }

    /**
     * Moves an Ant away from the world boundary in a north-west direction.
     * This only happens if the ant is currently out of bounds.
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     * @return True if the Ant was out of bounds, False if not.
     */
    private boolean moveBackNW(Ant ant, Tile[][] screen) {
        if (antOutOfBounds(ant, screen)) {
            ant.setLocX(ant.getLocX() - 1);
            ant.setLocY(ant.getLocY() - 1);
            moveRandomDiag(ant, screen);
            return true;
        }
        return false;
    }

    /**
     * Moves an Ant away from the world boundary in a north-east direction.
     * This only happens if the ant is currently out of bounds.
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     * @return True if the Ant was moved back into its bounds, False if not.
     */
    private boolean moveBackNE(Ant ant, Tile[][] screen) {
        if (antOutOfBounds(ant, screen)) {
            ant.setLocX(ant.getLocX() - 1);
            ant.setLocY(ant.getLocY() + 1);
            moveRandomDiag(ant, screen);
            return true;
        }
        return false;
    }


    /**
     * Returns whether the location of an Ant is currently outside
     * of the world bounds.
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     * @return True if the Ant was out of bounds, False if not.
     */
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

//    private boolean antOutOfBoundsForG(Ant ant, Tile[][] screen) {
//
//        if (screen[ant.getLocX()][ant.getLocY()] == Tile.S) {
//            return true;
//        }
//
//        if (screen[ant.getLocX()][ant.getLocY()] == Tile.T) {
//            return true;
//        }
//        return screen[ant.getLocX()][ant.getLocY()] == Tile.Q || screen[ant.getLocX()][ant.getLocY()] == Tile.G || screen[ant.getLocX()][ant.getLocY()] == Tile.W;
//
//
//    }

    /**
     * Randomly turns one non-Ant, non-Sky Tile into a food Tile
     * @param screen The current 100 x 100 Tile array
     */
    public void foodGenerator(Tile[][] screen) {
        Random rn = new Random();
        int x = rn.nextInt(89) + 10;
        int y = rn.nextInt(99) + 1;

        if (x < 100 && y < 100)
        {
            if (screen[x][y] == Tile.F)
                foodGenerator(screen);
            else
                screen[x][y] = Tile.F;
        }
    }

    /**
     * Returns whether an Ant is occupying a space with a Food Tile.
     * @param ant The ant that will be moved.
     * @param screen The array the ant moves through.
     * @return True if food was obtained, False if not.
     */
    public int isFood(Ant ant, Tile[][] screen) {
        if (screen[ant.getLocX()][ant.getLocY()] == Tile.F) {
            this.foodObtained++;
        }
        return this.foodObtained;
    }

    /**
     * Gets the amount of food obtained this round.
     * @return The total amount of food found.
     */
    public int getFoodObtained() {

        return foodObtained;

    }
}

