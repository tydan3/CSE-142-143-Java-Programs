// Daniel Ty
// 11/20/2017
// CSE 142
// TA: Josephine Lee
// Assignment #7
//
/* This program reads an input file containing named sequences of nucleotides and
      produces information about them.*/

import java.util.*;
import java.io.*;

public class DNA {
   public static final int MINIMUM_NUMBER_OF_CODONS = 5;
   public static final int PERCENTAGE = 30;
   public static final int UNIQUE_NUCLEOTIDES = 4;
   public static final int NUCCLEOTIDES_PER_CODON = 3;
   
   public static void main(String args[]) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
   
      intro();
      File search = search(console);
      Scanner input = new Scanner(search);
      PrintStream output = outputCreate(console);
      while (input.hasNextLine()) {
         String regionName = input.nextLine();
         String nucleotides = input.nextLine();
         nucleotides = nucleotides.toUpperCase();
         int[] nucCounts = nucCounts(nucleotides);
         double massSum = massSum(nucleotides);
         double[] massPercent = massPercent(nucCounts, massSum);
         String[] codonList = codonList(nucleotides);
         String protein = protein(nucleotides, massPercent, codonList);
         outputPrint(regionName, nucleotides, nucCounts, massSum, massPercent, 
               codonList, protein, output);
      }
   } 

   // Prints introduction
   public static void intro() {
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");    
   }
   
   // Prompts for input name. Returns input file.
   // console = Scanner for user input
   public static File search(Scanner console) {
      System.out.print("Input file name? ");
      File search = new File(console.nextLine());
      while (!search.exists()) {
         System.out.print("File not found. Try again: ");
         search = new File(console.nextLine());
      }
      return search;
   }
   
   // Creates output file and returns PrintStream for that file.
   // console = Scanner for user input
   public static PrintStream outputCreate (Scanner console) throws FileNotFoundException {
      System.out.print("Output file name? ");
      String outputName = console.nextLine();
      PrintStream output = new PrintStream(new File(outputName));
      return output;
   }

   
   // Prints text to output file.
   // regionName = String for region name
   // nucleotides = String of nucleotides
   // nucCounts = Array of unique nucleotides
   // massSum = sum of weight for nucleotides
   // massPercent = Array of each unique nucleotides weight %.
   // codonList = Array of codons
   // protein = "YES" or "NO"
   // output = PrintStream for output file
   public static void outputPrint(String regionName, String nucleotides, int[] nucCounts,
         double massSum, double[] massPercent, String[] codonList, String protein, 
         PrintStream output) {
      output.println("Region Name: " + regionName);
      output.println("Nucleotides: " + nucleotides);
      output.println("Nuc. Counts: " + Arrays.toString(nucCounts));
      output.println("Total Mass%: " + Arrays.toString(massPercent) +  " of " + 
            Math.round(massSum * 10.0) / 10.0);
      output.println("Codons List: " + Arrays.toString(codonList));
      output.println("Is Protein?: " + protein);
      output.println();
   }
   
   // Counts the amount of each unique nucleotide and puts them in an array. Returns array.
   // nucleotides = String of nucleotides
   public static int[] nucCounts(String nucleotides) {
      int[] nucCounts = new int[UNIQUE_NUCLEOTIDES];
      for (int i = 0; i <= nucleotides.length() - 1; i++) {
         if (nucleotides.charAt(i) == 'A') {
            nucCounts[0]++;
         } else if (nucleotides.charAt(i) == 'C') {
            nucCounts[1]++;
         } else if (nucleotides.charAt(i) == 'G') {
            nucCounts[2]++;
         } else if (nucleotides.charAt(i) == 'T') {
            nucCounts[3]++;
         }        
      }
      return nucCounts;
   }
   
   // Sums up the weight of the nucleotide String. Returns sum.
   // nucleotides = String of nucleotides
   public static double massSum(String nucleotides) {
      double massSum = 0;
      for (int i = 0; i <= nucleotides.length() - 1; i++) {
         if (nucleotides.charAt(i) == 'A') {
            massSum += 135.128;
         } else if (nucleotides.charAt(i) == 'C') {
            massSum += 111.103;
         } else if (nucleotides.charAt(i) == 'G') {
            massSum += 151.128;
         } else if (nucleotides.charAt(i) == 'T') {
            massSum += 125.107;
         } else {
            massSum += 100.000;
         }
      }
      return massSum;
   }
   
   // Calculates each unique nucleotide's weight percentages into an array. Returns array
   // nucCounts = array of unique nucleotides
   // massSum = sum of weight for nucleotides
   public static double[] massPercent(int[] nucCounts, double massSum)  {
      double[] massPercent = {135.128, 111.103, 151.128, 125.107};
      for (int i = 0; i <= UNIQUE_NUCLEOTIDES - 1; i++) {
         massPercent[i] = (massPercent[i] * nucCounts[i]) / massSum;
         massPercent[i] = Math.round(massPercent[i] * 1000.0) / 10.0;
      }
      return massPercent;
   }
   
   // Groups the nucleotides into groups of 3, called codons, in an array. Returns array
   // nucleotides = String of nucleotides
   public static String[] codonList(String nucleotides) {
      nucleotides = nucleotides.replace("-", "");
      String[] codonList = new String[nucleotides.length() / NUCCLEOTIDES_PER_CODON];
      for (int i = 0; i <= nucleotides.length(); i++) {
         if ((i * NUCCLEOTIDES_PER_CODON) + NUCCLEOTIDES_PER_CODON <= nucleotides.length()) {
           codonList[i] = nucleotides.substring((i * NUCCLEOTIDES_PER_CODON), 
               (i * NUCCLEOTIDES_PER_CODON) + NUCCLEOTIDES_PER_CODON);
         }
      }
      return codonList;
   }
   
   // Returns whether or not the nucleotide String is a protein.
   // nucleotides = String of nucleotides
   // massPercent = Array of each unique nucleotides weight %.
   // codonList = Array of codons
   public static String protein(String nucleotides, double[] massPercent, String[] codonList) {
      String protein = "YES";
      nucleotides = nucleotides.replace("-", "");
      if (!codonList[0].equals("ATG") || !stop(codonList, nucleotides) ||
            MINIMUM_NUMBER_OF_CODONS > nucleotides.length() / NUCCLEOTIDES_PER_CODON ||
            massPercent[1] + massPercent[2] < PERCENTAGE) {
         protein = "NO";
      }
      return protein;
   }
   
   // Returns whether or not nucleotide String has a stop codon.
   // codonList = Array containing codons
   // nucleotides = String of nucleotides
   public static boolean stop (String[] codonList, String nucleotides) {
      if (codonList[(nucleotides.length() / NUCCLEOTIDES_PER_CODON) - 1].equals("TAA")) {
         return true;
      } else if (codonList[(nucleotides.length() / NUCCLEOTIDES_PER_CODON) - 1].equals("TAG")) {
         return true;
      } else if (codonList[(nucleotides.length() / NUCCLEOTIDES_PER_CODON) - 1].equals("TGA")) {
         return true;
      } else {
         return false;
      }
   }
   
}