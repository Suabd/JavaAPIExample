import kong.unirest.Unirest;

import java.util.Map;

import static input.InputUtils.stringInput;

public class YelpSearch {
    public static void main(String[] args) {
        String yelpURL = "https://api.yelp.com/v3/businesses/search";
        String YELP_API_KEY = "2fhdV2aHnql8cGrbaxXIrnjqY-ltp3PwBpeWx_hEh_KYO1iIGkh55O_yDIwP7tkIyiEinko0nUIDZNB1XK-22KZGFnl21weIJl-EaWPXC6sN-CnegPRgxDMiWBBvZXYx";

        String typeOfRestaurant = stringInput("what type of restaurant you like to search for? ");
        Map<String, Object> yelpQuery = Map.of(
                "term", typeOfRestaurant,   // type of restaurant
                "location", "Minneapolis, MN",
                "categories", "restaurants",
                "price", "1"); // lowest price

        YelpResponse response = Unirest
                .get(yelpURL)
                .header("Authorization", "Bearer " + YELP_API_KEY)
                .queryString(yelpQuery)
                .asObject(YelpResponse.class).getBody();

        System.out.println(response);

        // gets the restrunt how mcuh stars they have a
        for (Business b : response.businesses) {
            System.out.println(b.name);
            System.out.println("Rating" + b.rating);
           // System.out.println(" " + b.location);
        }

    }
}
