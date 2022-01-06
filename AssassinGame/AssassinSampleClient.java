import java.io.*;
import java.util.*;

public class AssassinSampleClient {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the CSE143 Assassin Manager");
        System.out.println();
        System.out.print("What name file do you want to use this time? ");
        String fileName = console.nextLine();

        Scanner input = new Scanner(new File(fileName));
        Set<String> names = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        List<String> names2 = new ArrayList<String>();
        while (input.hasNextLine()) {
            String name = input.nextLine().trim();
            if (name.length() > 0 && !names.contains(name)) {
                names.add(name);
                names2.add(name);
            }
        }
      AssassinManager manager = new AssassinManager(names2);
      manager.printKillRing();
   }
}