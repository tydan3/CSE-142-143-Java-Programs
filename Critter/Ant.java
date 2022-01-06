// Daniel Ty
// 12/4/2017
// CSE 142
// TA: Josephine Lee
// Assignment #9 (Ant)
//
// This class creates an Ant Critter to be used in CritterMain.

import java.awt.*;

public class Ant extends Critter {
   private int moveCounter;
   private boolean walkSouth;
   
   // Constructs Ant object with a given boolean
   // walkSouth = true for south, false for north
   public Ant(boolean walkSouth) {
   this.walkSouth = walkSouth;
   }
   
   // Returns Ant's color
	public Color getColor() {
		return Color.RED;
	}

   // Returns whether or not the Ant eats
   public boolean eat() {
      return true;
   }
   
   // Returns Ant's fighting behavior
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}  
   
   // Returns Ant's direction of movement
   public Direction getMove() {
      moveCounter++;
      if (moveCounter % 2 == 0) { 
         return Direction.EAST;
      } else if (walkSouth) {
         return Direction.SOUTH;
      } else {
         return Direction.NORTH;
      }
   }

	// Returns what the Ant is drawn as
	public String toString() {
		return "%";
	}

}