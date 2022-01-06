// Daniel Ty
// 10/22/17
// CSE 142
// TA: Josephine Lee
// Assignment #4
//
// This program will compute a student's course grade.

import java.util.*;

public class Gradanator {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      intro();
      result(midterm(console), theFinal(console), homework(console));
   }
   
   // Prints an introduction explaining the program.
   public static void intro() {
      System.out.println("This program reads exam/homework scores"); 
      System.out.println("and reports your overall course grade.");
      System.out.println();
   }
   
   // Returns weighted midterm score.
   public static double midterm(Scanner console) {
      System.out.println("Midterm:");
      return examScore(console);      
   }
   
   // Returns weighted final score.
   public static double theFinal(Scanner console) {
      System.out.println("Final:");
      return examScore(console);  
   }
   
   // Computes user input and returns weighted scores for exams.
   public static double examScore(Scanner console) {
      System.out.print("Weight (0-100)? ");
      int weight = console.nextInt();
      System.out.print("Score earned? ");
      int score = console.nextInt();
      System.out.print("Were scores shifted (1=yes, 2=no)? ");
      int shift = console.nextInt();
      if (shift == 1) {
         System.out.print("Shift amount? ");
         shift = console.nextInt();
      } else {
         shift = 0;
      }
      int scoreShift = score + shift;
      if (scoreShift >= 100) {
         scoreShift = 100;
      } else {
         scoreShift = scoreShift;
      }
      double weightedScore = scoreShift / 100.0 * weight;
      System.out.println("Total points = " + scoreShift + " / " + 100);
      System.out.println("Weighted score = " + round1(weightedScore)+ " / " + weight);
      System.out.println();
      return weightedScore;
   }
   
   // Computes user input and returns weighted score for homework.   
   public static double homework(Scanner console) {
      System.out.println("Homework:");
      System.out.print("Weight (0-100)? ");
      int weight = console.nextInt();
      System.out.print("Number of assignments? ");
      int assignments = console.nextInt();
      int score = 0;
      int max = 0;
      for (int i = 1; i <= assignments; i++) {
         System.out.print("Assignment " + i + " score and max? ");
         score += console.nextInt();
         max += console.nextInt();
      }
      if (score >= max) {
         score = max;
      } else {
         score = score;
      }
      System.out.print("How many sections did you attend? ");
      int sections = console.nextInt();
      if (sections >= 6) {
         sections = 6;
      } else {
         sections = sections;
      }
      System.out.println("Section points = " + (sections * 5) + " / " + 30);
      double weightedScore = ((score + sections * 5) / (max + 30.0)) * weight;
      System.out.println("Total points = " + (score + sections * 5) + " / " + (max + 30));
      System.out.println("Weighted score = " + round1(weightedScore)+ " / " + weight);
      System.out.println();
      return weightedScore;
   }
   
   // Outputs user's overall percentage and minimum grade.
   // weightedMidterm = weighted score of midterm
   // weightedFinal = weighted score of final
   // weightedHw = weighted score of homework
   public static void result(double weightedMidterm, double weightedFinal, double weightedHw) {
      double grade = round1(weightedMidterm + weightedFinal + weightedHw);
      System.out.println("Overall percentage = " + grade);
      if (grade >= 85.0) {
         grade = 3.0;
         System.out.println("Your grade will be at least: " + grade);
         System.out.print("Great job.");
      } else if (grade >= 75.0) {
         grade = 2.0;
         System.out.println("Your grade will be at least: " + grade);
         System.out.print("Nice.");
      } else if (grade >= 60.0) {
         grade = 1.0;
         System.out.println("Your grade will be at least: " + grade);
         System.out.print("Maybe next time.");
      } else {
         grade = 0.0;
         System.out.println("Your grade will be at least: " + grade);
         System.out.print("RIP.");
      }
   }
   
   // Rounds number to tenth place.
   public static double round1(double number) {
      return Math.round(number * 10.0) / 10.0;
   }
}