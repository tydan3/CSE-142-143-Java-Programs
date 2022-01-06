// Daniel Ty
// CSE 143 AM
// TA: Sam Lee
// Homework 2 (Guitar37)
// Due 10/11/18

// Models a guitar that has 37 different strings.
public class Guitar37 implements Guitar {
   public static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
   private static final int KEYBOARD_LENGTH = KEYBOARD.length(); // The length of the keyboard (37 keys)
   private GuitarString[] keyboardKeys;
   private int ticTime = 0;
   
   // Constructs a guitar stringed with 37 notes on the chromatic scale from 110Hz to 880Hz.
   public Guitar37() {
      keyboardKeys = new GuitarString[KEYBOARD_LENGTH];
      for(int i = 0; i < KEYBOARD_LENGTH; i ++) {
         keyboardKeys[i] = new GuitarString(440.0 * Math.pow(2, ((i - 24.0) / 12.0)));
      }
   }
   
   // Plays a guitar string based on a given pitch.
   // Pitch refers to a note on the chromatic scale relative to concert-A.
   public void playNote(int pitch) {
      int note = pitch + 24;
      if ((note < KEYBOARD_LENGTH) && (note >= 0)) {
         keyboardKeys[note].pluck();
      }
   }
   
   // Checks if guitar has a certain string.
   // Key refers the keyboard key that correlates to a string on the guitar.
   public boolean hasString(char key) {
      return(KEYBOARD.indexOf(key) != -1);
   }
   
   // Plays a guitar string based on given key.
   // Key refers the keyboard key that correlates to a string on the guitar.
   public void pluck(char key) {
      if(!hasString(key)) {
         throw new IllegalArgumentException();
      }
      keyboardKeys[KEYBOARD.indexOf(key)].pluck();
   }
   
   // Returns sum of all guitar string samples.
   public double sample() {
      double sampleSum= 0.0;
      for(GuitarString keyboardKey : keyboardKeys) {
         sampleSum += keyboardKey.sample();
      }
      return sampleSum;
   }
   
   // Advances time by one tic for each guitar string.
   public void tic() {
      for (GuitarString keyboardKey : keyboardKeys) {
         keyboardKey.tic();
      }
      ticTime++;
   }
   
   // Returns a number of times tic has been called.
   public int time() {
      return ticTime;
   }
   
}