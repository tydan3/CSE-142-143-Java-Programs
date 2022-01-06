// Daniel Ty
// 12/4/2017
// CSE 142
// TA: Josephine Lee
// Assignment #9 (Bird)
//
// This class creates an Bird Critter to be used in CritterMain.

import java.awt.*;

public class Bird extends Critter {
   private int moveCounter;

   // Returns Bird's color
	public Color getColor() {
		return Color.BLUE;
	}
   
   // Returns Bird's fighting behavior
	public Attack fight(String opponent) {
		if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
	}
   
   // Returns Bird's direction of movement
   public Direction getMove() {
      moveCounter++;
      if (moveCounter > 12) {
         moveCounter = 1;
      }
      if (moveCounter <= 3) {
         return Direction.NORTH;
      } else if (moveCounter <= 6) {
         return Direction.EAST;
      } else  if (moveCounter <= 9) {
         return Direction.SOUTH;
      } else {
         return Direction.WEST;
      }         
   }

	// Returns what the Bird is drawn as
	public String toString() {
		 if (moveCounter <= 3) {
         return "^";
      } else if (moveCounter <= 6) {
         return ">";
      } else  if (moveCounter <= 9) {
         return "V";
      } else {
         return "<";
      }
	}

}