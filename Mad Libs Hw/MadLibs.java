// Daniel Ty
// 11/14/17
// CSE 142
// TA: Josephine Lee
// Assignment #6
//
/** This program allows the user to create and view "Mad Libs", which are short stories that have blanks
    called placeholders to be filled in.
*/

import java.util.*;
import java.io.*;

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
            
      intro();
      String command;
      do {
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         command = console.nextLine();
         
         if (command.equalsIgnoreCase("C") || command.equalsIgnoreCase("V")) {
            File search = search(console);
            Scanner input = new Scanner(search); 
            if (command.equalsIgnoreCase("C")) {
               create(console, input);
            } else {
               view(input);
            }
         System.out.println();
         }
      } while (!command.equalsIgnoreCase("Q"));
   
   }
      
   // Prints introduction to program.
   public static void intro() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   // Searches for a file and returns it.
   // console = Scanner for user input
   public static File search(Scanner console) {
      System.out.print("Input file name: ");
      File search = new File(console.nextLine());
      while (!search.exists()) {
         System.out.print("File not found. Try again: ");
         search = new File(console.nextLine());
      }
      return search;
   }
   
   // Creates a finished Mad Lib output file.
   // console = Scanner for user input
   // input = Scanner for input from text file
   public static void create(Scanner console, Scanner input) throws FileNotFoundException {
      System.out.print("Output file name: ");
      String outputName = console.nextLine();
      PrintStream output = new PrintStream(new File(outputName));
      System.out.println();
      while (input.hasNextLine()) {
         String line = input.nextLine();
         Scanner linescan = new Scanner(line);
         String firstWord = linescan.next();
         firstWord = placeholder(console, firstWord);
         while (linescan.hasNext()) {
            String word = linescan.next();
            word = placeholder(console, word);
            firstWord += " " + word;
         }
         output.println(firstWord);
      }
      System.out.println("Your mad-lib has been created!");
   }
   
   // Prints an existing text file.
   public static void view(Scanner input) {
      System.out.println();
      while (input.hasNextLine()) {
         String text = input.nextLine();
         System.out.println(text);
      }
   }
   
   // Checks if a word is a placeholder, replaces placeholder with user input.
   // console = Scanner for user input
   // word = words from a text file
   public static String placeholder(Scanner console, String word) {
     if (word.contains("<")) {
     word = word.replace("-", " ");   
        if (word.charAt(1) == 'a' || word.charAt(1) == 'e' || word.charAt(1) == 'i'
        || word.charAt(1) == 'o' || word.charAt(1) == 'u') {
           System.out.print("Please type an " + word.substring(1, word.length() - 1) + ": ");
        } else {
           System.out.print("Please type a " + word.substring(1, word.length() - 1) + ": ");
        }
        word = console.nextLine();
     }
     return word; 
   }
   
}