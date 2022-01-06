// Daniel Ty
// 12/4/2017
// CSE 142
// TA: Josephine Lee
// Assignment #9 (Hippo)
//
// This class creates an Hippo Critter to be used in CritterMain.

import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
   private int hunger;
   private int moveCounter;
   private int randomNumber;

   // Constructs Hippo object with a given int for amount of hunger
   public Hippo(int hunger) {
      this.hunger = hunger;
      Random rand = new Random();
      randomNumber = rand.nextInt(4);
   }
   
   // Returns Hippo's color
   public Color getColor() {
      if (hunger > 0) {
         return Color.GRAY;
      } else {
         return Color.WHITE;
      }
   }

   // Returns whether or not the Hippo eats
   public boolean eat() {
      if (hunger > 0) {
         hunger--;
         return true;
      } else {
         return false;
      }
   }
   
   // Returns Hippo's fighting behavior
   public Attack fight(String opponent) {
      if (hunger > 0) {
         return Attack.SCRATCH;
      } else {
         return Attack.POUNCE;
      }
   }
   
   // Returns Hippo's direction of movement
   public Direction getMove() {
      Random rand = new Random();
      moveCounter++;
      Direction[] d = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
      if (moveCounter > 5) {
         randomNumber = rand.nextInt(4);
         moveCounter = 1;
      }
      return d[randomNumber];      
   }

   // Returns what Hippo is drawn as
   public String toString() {
      String h = "" + hunger;
      return h;
   }
   
}