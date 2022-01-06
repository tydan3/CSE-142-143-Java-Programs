// Daniel Ty
// 10/10/17
// CSE 142
// TA: Josephine Lee
// Assignment #2 (Part A)
//
// This program will create a text art of an upwards facing arrow.
//
//    /\    
//   /  \
//  /    \
// /_    _\  
//   |  |
//   |  |
//   |__|

public class AsciiArt {
   public static void main(String[] args) {
   Arrowhead();
   Shaft();
   }
      
   //Draws head portion of arrow
   //    /\    
   //   /  \
   //  /    \
   // /_    _\  
   public static void Arrowhead() {
      for (int i = 1; i <= 3; i++) {
         //spaces
         for (int spaces = 1; spaces <= 5 - i; spaces++) {
            space();
         }
         //slash
         System.out.print("/");
         
         //insideSpace
         for (int insideSpace = 1; insideSpace <= (i * 2) - 2; insideSpace++) {
            space();
         }
         //backslash
         System.out.println("\\");
      }
      System.out.println(" /_    _\\");
   }
   
   //Draws shaft portion of arrow
   //   |  |
   //   |  |
   //   |__|
   public static void Shaft() {
      for (int i = 1; i <= 2; i++) {
         System.out.println("   |  |");
      }
      System.out.print("   |__|");
   }
   
   //Types " "
   public static void space() {
      System.out.print(" "); 
   }

}
      