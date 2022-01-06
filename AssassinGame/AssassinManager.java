// Daniel Ty
// CSE 143 AM
// TA: Sam Lee
// Homework 3 (AssassinManager)
// Due 10/18/18

import java.util.*;

// Manages a game of Assassin.
public class AssassinManager {
   private AssassinNode frontKillRing;
   private AssassinNode frontGraveyard;
   private AssassinNode current;
   
   // Constructs manager with given list of player names.
   // Throw IllegalArgumentException if list is empty.
   public AssassinManager(List<String> names) {
      if (names.size() == 0) {
         throw new IllegalArgumentException();
      }
      for (String player : names) {
         String assassinName = player;
         AssassinNode assassin = new AssassinNode(assassinName);
         if (frontKillRing == null) {
            frontKillRing = assassin;
         } else {
            current = frontKillRing;
            while (current.next != null) {
               current = current.next;
            }
            current.next = assassin;
         }
      }
   }
   
   // Prints names of assassins and their target.
   public void printKillRing() {
      current = frontKillRing;
      while (current != null) {
         if (current.next == null) {
            System.out.println("    " + current.name + " is stalking " + frontKillRing.name);
         } else {
            System.out.println("    " + current.name + " is stalking " + current.next.name);
         }
         current = current.next;
      }
   }
   
   // Prints names of dead assassins and their killers.
   public void printGraveyard() {
      current = frontGraveyard;
      while (current != null) {
         System.out.println("    " + current.name + " was killed by " + current.killer);
         current = current.next;
      }
   }
   
   // Returns whether a player is in the killring or not.
   // name refers to given player's name.
   public boolean killRingContains(String name) {
      return contains(name, frontKillRing);
   }
   
   // Returns whether a player is in the graveyard or not.
   // name refers to given player's name and is not case-sensitive.
   public boolean graveyardContains(String name) {
      return contains(name, frontGraveyard);
   }
   
   // Returns whether a player is in a given place or not.
   // name refers to given player's name and is not case-sensitive.
   public boolean contains(String name, AssassinNode place) {
      current = place;
      while (current != null) {
         if (current.name.equalsIgnoreCase(name)) {
            return true;
         }
         current = current.next;
      }
      return false;
   }
   
   // Returns whether the game is over or not.
   public boolean gameOver() {
      return frontKillRing.next == null;
   }
   
   // Returns name of the winner.
   public String winner() {
      return frontKillRing.name;
   }
   
   // Kills player with given name.
   // Given name is not case-sensitive.
   // Throws IllegalStateException if game is already over.
   // Throws IllegalArgumentException if given player name isn't in kill ring.
   public void kill(String name) {
      if (gameOver()) {
         throw new IllegalStateException();
      }
      if (!killRingContains(name)) {
         throw new IllegalArgumentException();
      }
      AssassinNode killed = null;
      String killerName = null;
      if (frontKillRing.name.equalsIgnoreCase(name)) {
         current = frontKillRing;
         while (current != null) {
            if (current.next == null) {
               killerName = current.name;
            }
            current = current.next;
         }
         killed = frontKillRing;
         killed.killer = killerName;
         frontKillRing = frontKillRing.next;  
      } else {
         current = frontKillRing;
         while (current.next != null) {
            if (current.next.name.equalsIgnoreCase(name)) {
               killerName = current.name;
               killed = current.next;
               killed.killer = killerName;         
               if (current.next.next == null) {
                  current.next = null;
               } else {
                  current.next = current.next.next;
               }
            }
            if (current.next !=null) {
               current = current.next;
            }
         }
      }
      if (frontGraveyard != null) {
         killed.next = frontGraveyard;
      } else {
         killed.next = null;
      }
      frontGraveyard = killed;
   }
   
}