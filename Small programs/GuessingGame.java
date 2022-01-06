// Daniel Ty
// 10/22/17
// CSE 142
// TA: Josephine Lee
// Assignment #5
//
// This program allows the user to play a guessing game.

import java.util.*;

public class GuessingGame {
   public static final int MAX = 100;
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      
      haiku();
      int totalGuesses = 0;
      int totalGames = 0;
      int minGuesses = 1000000;
      String rInitial;
      do {
         int guesses = game(console, rand);
         totalGuesses += guesses;
         totalGames++;
         if (minGuesses > guesses) {
            minGuesses = guesses;
         }
         System.out.print("Do you want to play again? ");
         String reply = console.next();
         rInitial = reply.substring(0, 1);
         System.out.println();
      } while (rInitial.equalsIgnoreCase("y"));
      results(totalGuesses, totalGames, minGuesses);
   }
   
   // Prints haiku introduction
   public static void haiku() {
      System.out.println("Want to play a game?");
      System.out.println("How about a guessing game?");
      System.out.println("Let's begin the game.");
      System.out.println();
   }
   
   // Plays the guessing game. Returns the amount of player tries.
   public static int game(Scanner console, Random rand) {
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      int answer = rand.nextInt(MAX) + 1;
      int guess;
      int guesses = 0;
      do {
         System.out.print("Your guess? ");
         guess = console.nextInt();
         if (guess > answer) {
            System.out.println("It's lower.");
         } else if (guess < answer) {
            System.out.println("It's higher.");
         }
         guesses++;
      } while (guess != answer);
      if (guesses == 1) {
         System.out.println("You got it right in 1 guess!");
      } else { 
         System.out.println("You got it right in " + guesses + " guesses!");
      }
      return guesses;
   }
   
   // Prints overall statistics about all games.
   // totalGuesses = total amount of guesses
   // totalGames = total amount of games
   // minGuesses = least guesses taken to win a game
   public static void results(int totalGuesses, int totalGames, int minGuesses) {
      System.out.println("Overall results:");
      System.out.println("Total games   = " + totalGames);
      System.out.println("Total guesses = " + totalGuesses);
      System.out.println("Guesses/game  = " + round1((double)totalGuesses/totalGames));
      System.out.println("Best game     = " + minGuesses);
   }
   
   // Rounds number to tenth place.
   public static double round1(double number) {
      return Math.round(number * 10.0) / 10.0;
   }
}