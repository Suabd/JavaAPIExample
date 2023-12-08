import javax.xml.stream.Location;

// Yelp API response classes to map JSON to Java Object.
public class YelpResponse {
    // field for businesses
    // what type?
    // it will be an array

    public Business[] businesses;

}

class Business {
    // represent one business object
    public String name;
    public double rating;

    //public Location location;

    // todo - what about location
    // street address of the business
}











