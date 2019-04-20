package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class BehaviorTest {


    @Test
    public void AntLocationTest(){
        //Queen should be always x =10 ,y= 50 in the nest
        Ant Q = new Queen();
        Ant K = new King(10,60);
        Ant W = new WorkingAnt(10,60);
        Ant G = new DiggingAnt(10,60);


        //Queen location test
        assertEquals(Q.getLocX(),10);
        assertEquals(Q.getLocY(),50);

        //WorkingAnt, DiggingAnt, King x location test
        assertEquals(K.getLocX(),10);
        assertEquals(W.getLocX(),10);
        assertEquals(G.getLocX(),10);

        //WorkingAnt, DiggingAnt, King y location test
        assertEquals(K.getLocY(),60);
        assertEquals(W.getLocY(),60);
        assertEquals(G.getLocY(),60);

    }

    @Test
    //King move test and ant out of boundary test as well
    public void moveRandomTest() {
        AntFarm a = new AntFarm();
        Behavior b = new Behavior();
        Ant w = new King(15, 70);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());

        //move that must pass
        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(90);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(93);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(93);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(93);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        /////////////////////////////////////
        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());

        ////////////////////////////////////
        w.setLocX(92);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());




        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(90);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(93);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(93);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(93);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        /////////////////////////////////////
        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());

        ////////////////////////////////////
        w.setLocX(92);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(90);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(93);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(93);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(93);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        /////////////////////////////////////
        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());



        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());

        ////////////////////////////////////
        w.setLocX(92);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());
        b.moveRandom(w,a.getScreen());




        //move that must fail
        w.setLocX(-2);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(1);
        w.setLocY(1);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));


        w.setLocX(9);
        w.setLocY(9);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(9);
        w.setLocY(0);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(1);
        w.setLocY(9);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));


    }

    @Test
    //WorkingAnt move test and ant out of boundary test as well
    public void moveRandomCross() {

        AntFarm a = new AntFarm();
        Behavior b = new Behavior();
        Ant w = new WorkingAnt(15, 70);
        b.antOutOfBounds(w,a.getScreen());


        b.moveRandom(w,a.getScreen());


        //move that must pass
        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(31);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        ////////////////////////////////



        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(31);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

//        w.setLocX(92);
//        w.setLocY(93);
//        b.antOutOfBounds(w,a.getScreen());
//
//        b.moveRandomCross(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(95);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());
        /////////////////////////////////////////////////
        //move that must pass
        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(31);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        ////////////////////////////////



        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(31);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(21);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(21);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

//        w.setLocX(92);
//        w.setLocY(93);
//        b.antOutOfBounds(w,a.getScreen());
//
//        b.moveRandomCross(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(95);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomCross(w,a.getScreen());
        /////////////////////////////////////////////////



        //move that must fail
        w.setLocX(-2);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(1);
        w.setLocY(1);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));


        w.setLocX(9);
        w.setLocY(9);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(9);
        w.setLocY(0);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(1);
        w.setLocY(9);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));
    }

    @Test
    //DiggingAnt move test and ant out of boundary test as well
    public void moveRandomDiag() {

        AntFarm a = new AntFarm();
        Behavior b = new Behavior();
        Ant w = new DiggingAnt(15, 70);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        //move that must pass
        w.setLocX(13);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(14);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(13);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(14);
        w.setLocY(91);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());


        w.setLocX(94);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        //////////////////////////
        w.setLocX(13);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(14);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(15);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(14);
        w.setLocY(94);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());



        /////////////////////////
        //move that must pass
        w.setLocX(13);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(14);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(13);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(14);
        w.setLocY(91);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());


        w.setLocX(94);
        w.setLocY(17);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        //////////////////////////
        w.setLocX(13);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(14);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(15);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());

        w.setLocX(14);
        w.setLocY(94);
        b.antOutOfBounds(w,a.getScreen());

        b.moveRandomDiag(w,a.getScreen());



        /////////////////////////


        //move that must fail
        w.setLocX(-2);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(-1);
        w.setLocY(1);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));


        w.setLocX(9);
        w.setLocY(9);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(9);
        w.setLocY(-3);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

        w.setLocX(1);
        w.setLocY(9);
        b.antOutOfBounds(w,a.getScreen());
        assertTrue(b.antOutOfBounds(w,a.getScreen()));

    }

    @Test
    //Queen move test and ant out of boundary test as well
    public void digToBottom() {

        AntFarm a = new AntFarm();
        Behavior b = new Behavior();
        Queen w = new Queen();
        b.antOutOfBounds(w,a.getScreen());


        b.digToBottom(w,a.getScreen());
        //move that must pass
        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(20);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(73);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(23);
        w.setLocY(66);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(45);
        w.setLocY(63);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(48);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(68);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

//        w.setLocX(92);
//        w.setLocY(11);
//        b.antOutOfBounds(w,a.getScreen());
//
//        b.digToBottom(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        //move that must pass
        w.setLocX(11);
        w.setLocY(40);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(20);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(60);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(73);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(23);
        w.setLocY(66);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(45);
        w.setLocY(63);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(50);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(11);
        w.setLocY(93);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(48);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(68);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(11);
        w.setLocY(11);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

//        w.setLocX(92);
//        w.setLocY(11);
//        b.antOutOfBounds(w,a.getScreen());
//
//        b.digToBottom(w,a.getScreen());

        w.setLocX(92);
        w.setLocY(14);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(15);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(16);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());


        w.setLocX(92);
        w.setLocY(92);
        b.antOutOfBounds(w,a.getScreen());

        b.digToBottom(w,a.getScreen());

    }
    @Test
    public void foodtest(){

        Behavior b = new Behavior();
        Tile[][] screen = new Tile[100][100];
        for(int i = 0; i<100; i++){
            for(int j =0; j<100; j++) {
                screen[i][j] = Tile.F;
            }
        }
        b.foodGenerator(screen);
    }


}