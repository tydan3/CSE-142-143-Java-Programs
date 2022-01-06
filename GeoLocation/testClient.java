public class testClient {
   public static void main(String[] args) {
      PlaceInformation test = new PlaceInformation("Space Needle", "Seattle Center",
                                  "tourist", 47.6205063, -122.3492774);
      System.out.println(test.getLocation());
   }
}