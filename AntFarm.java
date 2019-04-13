package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class AntFarm {
    private Tile[][] screen;


    private int playspeed;


    public AntFarm() {

        screen = new Tile[100][100];
        Random rn = new Random();

        int i;
        int ranK=0;
        int ranJ=0;

        for (int j = 0; j < 100; j++) {

            for (i = 0; i < 10; i++) {
                screen[i][j] = Tile.S;

            }
            for (int k = i; k < 100; k++) {
                screen[k][j] = Tile.D;

            }
        }
        playspeed=500;

       for(int n= 0; n<30;  n++){
            ranK = rn.nextInt(100) + 10;
            ranJ = rn.nextInt(100) + 1;
            if(ranK<100 && ranJ<100)
            screen[ranK][ranJ] = Tile.F;

        }

    }
    public int foodCounter(Tile[][] screen){
        int counter=0;
        for (int j = 0; j < 100; j++) {

            for (int i= 10; i < 100; i++) {
                if(screen[i][j] == Tile.F){
                counter++;
                }
            }
        }
        return counter;

    }
    public int WorkingantCounter(Tile[][] screen){
        int counter=0;
        for (int j = 0; j < 100; j++) {

            for (int i= 10; i < 100; i++) {
                if(screen[i][j] == Tile.W){
                    counter++;
                }
            }
        }
        return counter;


    }
    public int DiggingAntCounter(Tile[][] screen){
        int counter=0;
        for (int j = 0; j < 100; j++) {

            for (int i= 10; i < 100; i++) {
                if(screen[i][j] == Tile.G){
                    counter++;
                }
            }
        }
        return counter;

    }

    public int queenCounter(Tile[][] screen){
        int counter=0;
        for (int j = 0; j < 100; j++) {

            for (int i= 10; i < 100; i++) {
                if(screen[i][j] == Tile.Q){
                    counter++;
                }
            }
        }
        return counter;

    }


    public Tile[][] getScreen() {

        return screen;
    }


    public int getPlayspeed() {

        return playspeed;
    }

    public void setPlayspeed(int playspeed) {

        this.playspeed= playspeed;
    }


    public void save (Tile[][]screen, File file){

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
        public void load (File file, Tile[][]screen, Ant[] ants){
            try {
                Scanner fileReader = new Scanner(file);
                int i = 0;
                for (int r = 0; r < screen.length; r++) {

                    for (int c = 0; c < screen.length; c++) {

                        String t = fileReader.nextLine();

                        if (t.equalsIgnoreCase("A")) {
                            System.out.println("row " + r);
                            System.out.println("col " + c);
                            ants[i].setLocX(r);
                            ants[i].setLocY(c);
                            i++;
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
