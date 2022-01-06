// Daniel Ty
// 12/4/2017
// CSE 142
// TA: Josephine Lee
// Assignment #9 (Husky)
//
// This class creates an Husky Critter to be used in CritterMain.

import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   private int moveCounter;
   private int foodAte;

   // Returns Husky's color
   public Color getColor() {
      Color purple = new Color(128,0,128);
      Color gold = new Color(255,215,0);
      if (moveCounter % 2 == 0) { 
         return purple;
      } else {
         return gold;
      }
   }
   
   // Returns whether or not the Husky eats
   public boolean eat() {
      foodAte++;
      return true;
   }
   
   // Returns Husky's fighting behavior
	public Attack fight(String opponent) {
      Random rand = new Random();
      Attack[] a = {Attack.SCRATCH, Attack.POUNCE, Attack.ROAR};
      if (opponent.equals("%")) {
         return a[2];
      } else if (opponent.equals("^") || opponent.equals("V") || opponent.equals("<") ||
                 opponent.equals(">")) {
         return a[0];
      } else {
         return a[rand.nextInt(3)];
      }
   }
   
   // Returns Husky's direction of movement
   public Direction getMove() {
      moveCounter++;
      if (moveCounter > (8 + foodAte) * 2) {
         moveCounter = 1;
      }
      if (moveCounter <= 8 + foodAte) {
         if (moveCounter % 2 == 0) { 
            return Direction.SOUTH;
         } else {
            return Direction.EAST;
         }
      } else {
         if (moveCounter % 2 == 0) { 
            return Direction.NORTH;
         } else {
            return Direction.EAST;
         }
      }         
   }
     
   // Returns what the Husky is drawn as
   public String toString() {
      if (moveCounter % 2 == 0) { 
         return "BOUND";
      } else {
         return "LESS";
      }
   }

}