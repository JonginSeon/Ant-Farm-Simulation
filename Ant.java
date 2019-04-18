package main;

/**
 * Establishes the minimum functionality for all Ants, including WorkingAnts, DiggingAnts,
 * Kings, and Queens.
 */
public interface  Ant{

   void setLocX(int locX);
   void setLocY(int locY);
   int getLocX();
   int getLocY();
   Tile getAntTile();
}
