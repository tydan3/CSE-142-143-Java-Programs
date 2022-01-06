// Daniel Ty
// CSE 143 AM
// TA: Sam Lee
// Homework 1 (Letter Inventory)
// Due 10/4/18

import java.util.*;

// Creates and manages an inventory of letters within a given string.
public class LetterInventory {
   private int[] elementData;
   private int size;
   
   public static final int ALPHABET = 26;
   
   // Constructs an inventory that tracks the number 
   // of each letter within the given string (data).
   public LetterInventory(String data) {
      elementData = new int[ALPHABET];
      size = 0;
      data = data.toLowerCase();
      for (int i = 0; i < data.length(); i++) {
         if (Character.isLetter(data.charAt(i))) {
         elementData[data.charAt(i) - 'a']++;
         size++;
         }
      }
   }
   
   // Returns the number of letters in the inventory.
   public int size() {
      return size;
   }
   
   // Returns whether the inventory is empty or not.
   // True if empty, False if not empty.
   public boolean isEmpty() {
      return size == 0;
   }
   
   // Returns how much of the given letter is in the inventory.
   // Throws IllegalArgumentException if given letter is not a letter.
   public int get(char letter) {
      if (!Character.isLetter(letter)) {
         throw new IllegalArgumentException("letter: " + letter);
      }
      letter = Character.toLowerCase(letter);
      return elementData[letter - 'a'];
   }
   
   // Returns a representation of the inventory in a String.
   // Represented as a bracketed alphabetical list of letters.
   public String toString() {
      if (size == 0) {
         return "[]";
      } else {
         String result = "[";
         for (int i = 0; i < ALPHABET; i++) {
            for (int j = 0; j < elementData[i]; j++) {
               result += (char)(i + 'a');
            }
         }
         result += "]";
         return result; 
      }
   }
   
   // Modifies an amount (value) of a given letter in an inventory.
   // Throws IllegalArgumentException if given letter is not a letter.
   public void set(char letter, int value) {
      letter = Character.toLowerCase(letter);
      if (!Character.isLetter(letter)) {
         throw new IllegalArgumentException("letter: " + letter);
      }
      size += value - elementData[letter - 'a'];
      elementData[letter - 'a'] = value;
   }
   
   // Contructs a LetterInventory whose letters is the sum of
   // this inventory's letters and a given inventor's letters.
   public LetterInventory add(LetterInventory other) {
      LetterInventory sum = new LetterInventory("");
      for (int i = 0; i < ALPHABET; i++) {
         sum.elementData[i] = elementData[i] + other.elementData[i];
         sum.size = size + other.size;
      }
      return sum;
   }
   
   // Contructs a LetterInventory whose letters is the difference of
   // this inventory's letters and a given inventory's letters.
   // Returns null if difference of any letters is negative.
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory difference = new LetterInventory("");
      for (int i = 0; i < ALPHABET; i++) {
         if (elementData[i] - other.elementData[i] < 0) {
            return null;
         }
         difference.elementData[i] = elementData[i] - other.elementData[i];
         difference.size = size - other.size;
      }
      return difference;
   }
   
}   