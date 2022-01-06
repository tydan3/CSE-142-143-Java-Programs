import java.util.*;

// Sample client of ArrayList
public class ArrayListExample {

    public static void main(String[] args) {
        // String[] array = new String[50];
        ArrayList<String> list = new ArrayList<String>();

        // array[0] = "According";
        list.add("According");
        list.add("to");
        list.add("some");  // seems wrong...
        list.add("known");
        list.add("laws");
        list.add("of");
        list.add("aviation");
        list.sort();

        System.out.println(list);
        // Same as System.out.println(list.toString());

        list.remove(2);
        System.out.println(list);

        list.add(2, "all");
        System.out.println(list);
    }
}