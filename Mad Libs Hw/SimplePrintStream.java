import java.util.*; // for PrintStream
import java.io.*;   // for File

public class SimplePrintStream {
    // we need to declare the possibility of the FileNotFoundException, just like 
    // with a file input scanner
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("output.txt"));
        output.print("x = x ");
        output.println("y + z");

        // We can also pass 'output' as a parameter to a method to have
        // the boxOfStars method print to a file:
        boxOfStars(3, 4, output);

        // Note that System.out is also PrintStream. Here, we're passing
        // System.out as a parameter to make the method print to the user console:
        boxOfStars(5, 7, System.out);
    }

    // Takes a width and height and prints a box of that shape to the given
    // output PrintStream
    public static void boxOfStars(int width, int height, PrintStream output) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                output.print("*");
            }
            output.println();
        }
    }
}