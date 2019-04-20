package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AntFarmTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void AntFarmConstructorTest(){
        AntFarm t = new AntFarm();
        String[][] arr;
        arr = new String [100][100];
        assertSame(t.getScreen().length,arr.length);
        assertEquals(t.getPlayspeed(),500);


    }
    @Test
    public void getScreenTest() {
        AntFarm t = new AntFarm();
        assertNotNull(t.getScreen());

    }

    @Test
    public void getPlayspeed() {
        AntFarm t = new AntFarm();
        assertEquals(t.getPlayspeed(),500);
        t.setPlayspeed(600);
        assertEquals(t.getPlayspeed(),600);
    }

    @Test
    public void setPlayspeed() {
        AntFarm t = new AntFarm();
        t.setPlayspeed(700);
        assertEquals(t.getPlayspeed(),700);

    }

    @Test
    public void foodCounter(){
        Tile[][] screen = new Tile[100][100];
        AntFarm a = new AntFarm();
        screen[20][54]=Tile.F;
        screen[22][33]=Tile.F;
         System.out.println("Food"+a.foodCounter(screen));

    }
    @Test
    public void workingAntCounter(){
        Tile[][] screen = new Tile[100][100];
        screen[11][50]=Tile.W;
        screen[22][33]=Tile.W;

        AntFarm a = new AntFarm();
        System.out.println("W"+a.workingAntCounter(screen));

    }

    @Test
    public void QueenCounter(){
        Tile[][] screen = new Tile[100][100];
        screen[11][50]=Tile.Q;
        screen[22][33]=Tile.Q;
        AntFarm a = new AntFarm();
        System.out.println("Q"+a.queenCounter(screen));
    }

    @Test
    public void kingCounter(){

        AntFarm a = new AntFarm();
        Tile[][] screen = new Tile[100][100];
        screen[11][50]=Tile.K;
        screen[22][33]=Tile.K;
        System.out.println("K"+a.kingCounter(screen));
    }
    @Test
    public void DiggingAntCounter(){
        AntFarm a = new AntFarm();
        Tile[][] screen = new Tile[100][100];
        screen[65][26]=Tile.D;
        screen[34][83]=Tile.D;
        System.out.println("D"+a.diggingAntCounter(screen));
    }
}

