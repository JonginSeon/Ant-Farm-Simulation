package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AntFarm {
    private Tile[][] screen;
    private Tile[][] temp= new Tile[100][100];
    private Tile[][] temp2= new Tile[100][100];
    private Tile[][] temp3= new Tile[100][100];
    private ArrayList<AntType> type = new ArrayList<AntType>();
    AntGui gui = new AntGui();

    private int playspeed;
    private int[] speedInfo;


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
        playspeed=500;
    }

    //add an Ant to list
    public void add(AntType c) {
        type.add(c);

    }

    public AntType get(int i) {
        return type.get(i);

    }

    public int getSize() {
       // System.out.println(type.size());
        return type.size();
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
        public void load (File file, Tile[][]screen, Ant ant){
            try {
                Scanner fileReader = new Scanner(file);
                for (int r = 0; r < screen.length; r++) {

                    for (int c = 0; c < screen.length; c++) {

                        String t = fileReader.nextLine();

                        if (t.equalsIgnoreCase("A")) {
                            System.out.println("row " + r);
                            System.out.println("col " + c);
                            ant.setLocX(r);
                            ant.setLocY(c);
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
