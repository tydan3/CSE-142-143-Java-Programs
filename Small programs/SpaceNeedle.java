// Daniel Ty
// 10/10/17
// CSE 142
// TA: Josephine Lee
// Assignment #2 (Part B)
//
// This program will create a resizeable text art of the space needle.         

public class SpaceNeedle {
   public static final int SIZE = 2;
   
   public static void main(String[] args) {
   Needle();
   TopSaucer();
   MidSaucer();
   BottomSaucer();
   Needle();
   ThickNeedle();
   TopSaucer();
   MidSaucer();
   }

   // Types the needle.   
   //            ||
   //            ||
   //            ||
   //            ||
   public static void Needle() {
      for (int i = 1; i <= SIZE; i++) {
         for (int spaces = 1; spaces <= SIZE * 3; spaces++) {
            Space();
         }
         DoubleBar();
         NextLine();
      }
   }
   
   // Types the top half of the saucer.   
   //         __/||\__
   //      __/:::||:::\__
   //   __/::::::||::::::\__
   //__/:::::::::||:::::::::\__
   public static void TopSaucer() {
      for (int i = 1; i <= SIZE; i++) {
         for (int spaces = 1; spaces <= (-3 * i) + (SIZE * 3); spaces++) {
            Space();
         }
         Underscore();
         System.out.print("/");
         for (int colons = 1; colons <= (3 * i) - 3; colons++) {
            Colon();
         }
         DoubleBar();
         for (int colons = 1; colons <= (3 * i) - 3; colons++) {
            Colon();
         }
         System.out.print("\\");
         Underscore();
         NextLine();
      }
   }

   // Types the mid section of the saucer.      
   //|""""""""""""""""""""""""|
   public static void MidSaucer() {
      Bar();
      for (int i = 1; i <= SIZE * 6; i++ ) {
         System.out.print("\"");
      }
      Bar();
      NextLine();
   }
   
   // Types the bottom half of the saucer.
   //\_/\/\/\/\/\/\/\/\/\/\/\_/
   //  \_/\/\/\/\/\/\/\/\/\_/
   //    \_/\/\/\/\/\/\/\_/
   //      \_/\/\/\/\/\_/
   public static void BottomSaucer() {
      for (int i = 1; i <= SIZE; i++) {
         for (int spaces = 1; spaces <= (2 * i) -2; spaces++) {
            Space();
         }
             
         System.out.print("\\_");
         for (int triangle = 1; triangle <= ((SIZE * 3) + 1) - (2 * i); triangle++) { 
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }

   // Types the thicker part of the needle.
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   //|%%||%%|
   public static void ThickNeedle() {
      for (int i = 1; i <= SIZE * SIZE; i++) {
         for (int spaces = 1; spaces <= (SIZE * 2) + 1; spaces++) {
            Space();
         }
         Bar();
         for (int percent = 1; percent <= SIZE - 2; percent++) {
            Percent();
         }
         DoubleBar();
         for (int percent = 1; percent <= SIZE - 2; percent++) {
            Percent();
         }
         Bar();
         NextLine();
      }
   }         

   //Types " "
   public static void Space() {
      System.out.print(" ");
   }
   //Types "||"
   public static void DoubleBar() {
      System.out.print("||");
   }
   //Ends line
   public static void NextLine() {
      System.out.println();
   }
   //Types ":"
   public static void Colon() {
      System.out.print(":");
   }
   //Types "__"
   public static void Underscore() {
      System.out.print("__");
   }
   //Types "|"
   public static void Bar() {
      System.out.print("|");
   }
   //Types "%"
   public static void Percent() {
      System.out.print("%");
   }

}