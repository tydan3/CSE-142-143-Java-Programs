// Daniel Ty
// 11/27/2017
// CSE 142
// TA: Josephine Lee
// Assignment #8 (Part C)
//
// This class stores information about a place. The class includes a method for
// computing the distance between two places.

public class PlaceInformation {
   private String name;
   private String address;
   private String tag;
   private double latitude;
   private double longitude;

   // constructs a place information object with given name, address, tag, latitude,
   // and longitude.
   public PlaceInformation(String name, String address, String tag,
                        double latitude, double longitude) {
      this.name = name;
      this.address = address;
      this.tag = tag;
      this.latitude = latitude;
      this.longitude = longitude;
   }
   
   // returns the name of this place
   public String getName() {
      return name;
   }
   
   // returns the address of this place
   public String getAddress() {
      return address;
   }
   
   // returns the tag(s) of this place
   public String getTag() {
      return tag;
   }
   
   // returns a string representation of this place's name, latitude, and longitude 
   public String toString() {
      return name + " (latitude: " + latitude + ", longitude: " + longitude + ")";
   }

   // constructs and returns a GeoLocation object of this place
   public GeoLocation getLocation() {
      GeoLocation geoLocation = new GeoLocation(latitude, longitude);
      return geoLocation;
   }
   
   // constructs a GeoLocation object of this place and returns the distance in miles between
   // it and the given geo location, "spot"
   public double distanceFrom(GeoLocation spot) {
      GeoLocation geoLocation = new GeoLocation(latitude, longitude);
      return geoLocation.distanceFrom(spot);
   }
   
}   