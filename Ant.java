
package main;

/**
 * Establishes the minimum functionality for all Ants, including WorkingAnts,
 * DiggingAnts, Kings, and Queens.
 */
public interface  Ant {
   /**
    * Sets the X-coordinate for this ant.
    * @param locX The new X-coordinate
    */
   void setLocX(int locX);

   /**
    * Sets the Y-coordinate for this ant.
    * @param locY The new Y-coordinate
    */
   void setLocY(int locY);

   /**
    * Gets the X-coordinate for this ant.
    * @return The X-coordinate
    */
   int getLocX();

   /**
    * Gets the Y-coordinate for this ant.
    * @return The Y-coordinate
    */
   int getLocY();

   /**
    * Gets the Tile type for this ant.
    * @return This ant's Tile type
    */
   Tile getAntTile();
}

