import java.util.*;

public class Practice {
   public static void main(String[] args) {
   ArrayList<Integer> list = new ArrayList<Integer>(); //{5, 7, 7, 7, 8, 22, 22, 23, 31, 35, 35, 40, 40, 40, 41};
   list.add(4);
   list.add(5);
   list.add(3);
   list.add(8);
   list.add(5);
   list.add(6);
   //System.out.print(111 % 2);
   rearrange(list);
   System.out.print(list);
   
   }
   
   public static boolean test (int[] list) {
      for (int i = 0; i< list.length -1; i += 2) {
         if (list[i] > list[i + 1]) {
            return false;
         }
      }
      return true;
   }
   
   public static void reverse(ArrayList<Integer> list) {
      for (int i = 0; i <list.size() - 2; i += 3) {
         list.add(i, list.remove(i + 2));
         list.add(i + 2, list.remove(i + 1));
      }
   }
   
   public static void rearrange(ArrayList<Integer> list) {
      for (int i = 1; i <= list.size() / 2; i++) {
         list.add(list.remove(i));
      }
   }
}