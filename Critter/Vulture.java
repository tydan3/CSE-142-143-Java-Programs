// Daniel Ty
// 12/4/2017
// CSE 142
// TA: Josephine Lee
// Assignment #9 (Vulture)
//
// This class creates an Vulture Critter to be used in CritterMain.

import java.awt.*;

public class Vulture extends Bird {
   private boolean hunger = true;

   // Returns Vulture's color
   public Color getColor() {
      return Color.BLACK;
   }
   
   //Returns whether or not the Vulture eats
   public boolean eat() {
      if (hunger) {
         hunger = false;
         return true;
      } else {
         return false;
      }   
   }

   // Returns Vulture's fighting behavior
   public Attack fight(String opponent) {
		hunger = true;
      if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
	}  
  
}