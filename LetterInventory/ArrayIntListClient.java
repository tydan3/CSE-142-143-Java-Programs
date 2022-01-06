// Sample client of ArrayIntList
public class ArrayIntListClient {
    public static void main(String[] args) {
        ArrayIntList list1 = new ArrayIntList();
        ArrayIntList list2 = new ArrayIntList();
        list1.add(100);
        list1.add(82);
        list1.add(97);
        list2.add(7);
        list2.add(-8);
        System.out.println(list1);
        System.out.println(list2);
    }
}