// Sample client
public class LetterInventoryClient {
    public static void main(String[] args) {
        LetterInventory list1 = new LetterInventory("aabbbcc");
        System.out.println(list1);
        System.out.println(list1.get('2'));
    }
}