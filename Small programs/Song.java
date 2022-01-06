// Daniel Ty
// 10/3/17
// CSE 142
// TA: Josephine Lee
// Assignment #1
//
/** This program will use static methods and println statements to write a cumulative song,
while also avoiding redundancy.
*/ 

public class Song {
   public static void main(String[] args) {
      verse1();
      verse2();
      verse3();
      verse4();
      verse5();
      verse6();
      verse7();
   }
   
   /** Writes the first verse of the song.
   */
   public static void verse1() {
      System.out.println("There was an old woman who swallowed a fly.");
      fly();
      System.out.println();
   }
   
   /** Writes the second verse of the song.
   */
   public static void verse2() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      fs();
      System.out.println();
   }
   
   /** Writes the third verse of the song.
   */
   public static void verse3() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      fsb();
      System.out.println();
   }
   
   /** Writes the fourth verse of the song.
   */
   public static void verse4() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      fsbc();
      System.out.println();
   }
   
   /** Writes the fifth verse of the song.
   */
   public static void verse5() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      fsbcd();
      System.out.println();
   }
   
   /** Writes the sixth verse of the song.
   */
   public static void verse6() {
      System.out.println("There was an old woman who swallowed a fox");
      System.out.println("Must have thought outside the box to swallow the fox");
      System.out.println("She swallowed the fox to catch the dog");
      fsbcd();
      System.out.println();
   }
   
   /** Writes the seventh verse of the song.
   */
   public static void verse7() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   /** Writes the "...swallowed that fly," and "Perhaps she'll die." lines.
   */
   public static void fly() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
   
   /** Writes the "...spider to catch the fly," line.
   */
   public static void spider() {
      System.out.println("She swallowed the spider to catch the fly,");
   }
   
   /** Writes the "...bird to catch the spider," line.
   */
   public static void bird() {
      System.out.println("She swallowed the bird to catch the spider,");
   }
   
   /** Writes the "...cat to catch the bird," line.
   */
   public static void cat() {
      System.out.println("She swallowed the cat to catch the bird,");
   }
   
   /** Writes the "...dog to catch the cat," line.
   */
   public static void dog() {
      System.out.println("She swallowed the dog to catch the cat,");
   }
   
   /** Combines the fly() and spider() static methods.
   */
   public static void fs() {
      spider();
      fly();
   }
   
   /** Combines the fs() and bird() static methods.
   */
   public static void fsb() {
      bird();
      fs();
   }
   
   /** Combines the fsb() and cat() static methods.
   */
   public static void fsbc() {
      cat();
      fsb();
   }
   
   /** Combines the fsbc() and dog() static methods.
   */
   public static void fsbcd() {
      dog();
      fsbc();
   }

}