// Daniel Ty
// CSE 143 AM
// TA: Sam Lee
// Homework 4 (Evil Hangman)
// Due 10/25/18

import java.util.*;

// Keeps track of a game of hangman.
public class HangmanManager {
   private Set<String> wordOptions;
   private Set<Character> lettersGuessed;
   private String pattern;
   private int guessesRemaining;
   private int wordLength;
   
   // Initializes Hangman game with given dictionary of words, target word length, and 
   // max guesses allowed.
   // throws IllegalArgumentException if length is less than 1 or if max is less than 0.
   public HangmanManager(Collection<String> dictionary, int length, int max) {
      if (length < 1 || max < 0) {
         throw new IllegalArgumentException();
      }
      wordOptions = new HashSet<String>();
      for (String word : dictionary) {
         if (word.length() == length) {
            wordOptions.add(word);
         }
      }
      guessesRemaining = max;
      lettersGuessed = new TreeSet<Character>();
      pattern = "-";
      for (int i = 1; i < length; i++) {
         pattern += " -";
      }
      wordLength = length;
   }
   
   // Returns current set of words being considered by this manager
   public Set<String> words() {
      return wordOptions;
   }
   
   // Returns how many guesses the player has left.
   public int guessesLeft() {
      return guessesRemaining;
   }
   
   // Returns set of letters that were guessed by the player.
   public Set<Character> guesses() {
      return lettersGuessed;
   }

   // Return pattern of answer based on guesses made.
   // Letters are seperated by spaces, and dashes represent letters not guessed yet.
   // Throws IllegalStateException if the set of words is empty.
   public String pattern() {
      if (wordOptions.isEmpty()) {
         throw new IllegalStateException();
      }
      return pattern;
   }
   
   // Records the player's next guess. Returns the number of occurrences of the 
   // guessed letter in the answer's pattern. Updates guesses left.
   // Throws IllegalStateException if guesses left is less than 1 or if set of words is empty.
   // Throws IllegalArgumentException if set of words is not empty and
   // guessed letter was guessed before.
   public int record(char guess) {
      if (guessesRemaining < 1 || wordOptions.isEmpty()) {
         throw new IllegalStateException();
      }
      if (!wordOptions.isEmpty() && lettersGuessed.contains(guess)) {
         throw new IllegalArgumentException();
      }
      lettersGuessed.add(guess);
      Map<String, HashSet<String>> PatternMap = new TreeMap<String, HashSet<String>>();
      for (String word : wordOptions) {
         changePattern(word);
         if (!PatternMap.containsKey(pattern)) {
            PatternMap.put(pattern, new HashSet<String>());
         }
         PatternMap.get(pattern).add(word);
      }
      int mostStrings = 0;
      String keyPattern = "";
      for (String key : PatternMap.keySet()) {
         Set<String> temp = PatternMap.get(key);
         if (temp.size() > mostStrings) {
            mostStrings = PatternMap.get(key).size();
            keyPattern = key;
         }
      }
      wordOptions = PatternMap.get(keyPattern);
      pattern = keyPattern;
      return guessedCorrect(keyPattern, guess);  
   }
   
   // Changes pattern based on given word.
   private void changePattern(String word) {
      pattern = "";
      if (lettersGuessed.contains(word.charAt(0))) {
         pattern += word.charAt(0);
      } else {
         pattern += "-";
      }
      for (int i = 1; i < wordLength; i++) {
         if (lettersGuessed.contains(word.charAt(i))) {
            pattern += " " + word.charAt(i);
         } else { 
            pattern += " -";
         }
      }
   } 
   
   // Returns number of correct letters for a given guess.
   private int guessedCorrect(String keyPattern, char guess) {
      int guessedCorrect = 0;
      for (int i = 0; i < keyPattern.length(); i++) {
         if (keyPattern.charAt(i) == guess) {
            guessedCorrect++;
         }
      }
      if (guessedCorrect == 0) {
         guessesRemaining--;
      }
      return guessedCorrect;
   }
   
}