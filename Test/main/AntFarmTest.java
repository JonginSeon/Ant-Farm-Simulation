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
    public void getAntLocX(){
        AntFarm t = new AntFarm();
        assertEquals(t.getAntLocX(),10);
        t.setAntLocX(60);
        assertEquals(t.getAntLocX(),60);
    }

    @Test
    public void setAntLocX(){
        AntFarm t = new AntFarm();
        t.setAntLocX(70);
        assertEquals(t.getAntLocX(),70);

    }
    @Test
    public void getAntLocY(){
        AntFarm t = new AntFarm();
        assertEquals(t.getAntLocY(),50);
        t.setAntLocY(40);
        assertEquals(t.getAntLocY(),40);
    }

    @Test
    public void setAntLocY(){
        AntFarm t = new AntFarm();
        t.setAntLocY(70);
        assertEquals(t.getAntLocY(),70);

    }


    @Test
    public void moveRandomTest() {
        AntFarm t = new AntFarm();

        t.antOutOfBounds(11,50);
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));

        t.antOutOfBounds(11,70);
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));

        t.antOutOfBounds(20,99);
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));

        t.antOutOfBounds(11,99);
        t.moveRandom();
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));


        t.antOutOfBounds(99,50);
        t.moveRandom();
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));


        t.antOutOfBounds(99,90);
        t.moveRandom();
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));


        t.antOutOfBounds(21,11);
        t.moveRandom();
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));


        t.antOutOfBounds(32,11);
        t.moveRandom();
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));


        t.antOutOfBounds(20,11);
        t.moveRandom();
        t.moveRandom();
        assertFalse(t.antOutOfBounds(t.getAntLocX(),t.getAntLocY()));


    }


    @Test
    public void antOutOfBoundsTest() {
        AntFarm t = new AntFarm();
        //0-9 sky tile in y direction
        //antOutOfBounds returns ture --> bad
        //antOutOfBounds returns false --> good
        assertTrue(t.antOutOfBounds(9,50));
        assertTrue(t.antOutOfBounds(111,111));
        assertTrue(t.antOutOfBounds(51,111));
        assertTrue(t.antOutOfBounds(111,50));
        assertFalse(t.antOutOfBounds(50,50));
        assertTrue(t.antOutOfBounds(99,1));
        assertTrue(t.antOutOfBounds(9,99));
        assertTrue(t.antOutOfBounds(1,99));
        assertFalse(t.antOutOfBounds(11,99));
        assertTrue(t.antOutOfBounds(0,0));
        assertTrue(t.antOutOfBounds(-1,100));
        assertTrue(t.antOutOfBounds(100,-1));

    }

    @Test
    public void save() {
    }

    @Test
    public void load() {
    }
}

