// Daniel Ty
// 11/27/2017
// CSE 142
// TA: Josephine Lee
// Assignment #8 (Part B)
//
// This program constructs and manipulates three GeoLocation objects.

public class GeoLocationClient {
   public static void main(String[] args) {
      GeoLocation stash = new GeoLocation(34.988889, -106.614444);
      GeoLocation abq = new GeoLocation(34.989978, -106.614357);
      GeoLocation fbi = new GeoLocation(35.131281, -106.61263);
      System.out.println("the stash is at " + stash.toString());
      System.out.println("ABQ studio is at " + abq.toString());
      System.out.println("FBI building is at " + fbi.toString());
      System.out.println("distance in miles between:");
      System.out.println("\tstash/studio = " + stash.distanceFrom(abq));
      System.out.println("\tstash/fbi    = " + stash.distanceFrom(fbi));
   }  
}