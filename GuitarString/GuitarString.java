// Daniel Ty
// CSE 143 AM
// TA: Sam Lee
// Homework 2 (Guitar String)
// Due 10/11/18

import java.util.*;

// Simulates a vibrating guitar string.
public class GuitarString {
   public static final double DECAY_FACTOR = 0.996;   //energy decay factor
   private Queue<Double> ringBuffer;
   private int ringSize;
   
   // Constructs a guitar string with a given frequency.
   // Frequency refers to the frequency of a vibrating guitar string.
   // Throws IllegalArgumentException if ring buffer size is less or equal to 0, or less than 2.
   public GuitarString(double frequency) {
      ringSize = (int)Math.round(StdAudio.SAMPLE_RATE / frequency);
      if (frequency <= 0 || ringSize < 2) {
         throw new IllegalArgumentException();
      }
      ringBuffer = new LinkedList<Double>();
      for (int i = 0; i < ringSize; i++) {
         ringBuffer.add(0.0);
      }
   }
   
   // Constructs a guitar string, initializes ring buffer elements with given array elements.
   // Init refers to an array used for testing purposes.
   // Throws IllegalArgumentException if the ring buffer has less than 2 elements.
   public GuitarString(double[] init) {
      ringSize = init.length;
      if (ringSize < 2) {
         throw new IllegalArgumentException();
      }
      ringBuffer = new LinkedList<Double>();
      for (Double element : init) {
         ringBuffer.add(element);
      }
      System.out.println(ringBuffer);
   }
   
   // Fills ring buffer with white noise to simulate plucking a string.
   public void pluck() {
      Random rand = new Random();
      double randNumber;
      for (int i = 0; i < ringSize; i++) {
         randNumber = rand.nextDouble() - 0.5;
         ringBuffer.add(randNumber);
         ringBuffer.remove();
      }
   }
   
   // Applies the Karplus-Strong update once to ring buffer.
   public void tic() {
      double first = ringBuffer.remove();
      double second = ringBuffer.peek();
      ringBuffer.add(((first + second) / 2) * DECAY_FACTOR);
   }
   
   // Returns value that is in the front of ring buffer.
   public double sample() {
      return ringBuffer.peek();
   }
   
}