import kong.unirest.Unirest;

import java.util.Map;
import java.util.Objects;

import static input.InputUtils.doubleInput;

public class ExchangeRateConverter {
    public static void main(String[] args) {
        String url = "https://1150-exchange-rates.azurewebsites.net/latest?base=USD&symbols=EUR";
        // todo make request here

        Map<String, Object> queryParmaters = Map.of("base", "USD", "symbols","EUR");

        RateResponse response = Unirest.get(url).queryString(queryParmaters) .asObject(RateResponse.class).getBody();
        String dateRequested = response.date;
        double rate = response.rates.EUR;
        double amountOfDollars = doubleInput("How many US Dollars to convert to Euros");
        double euroEquivalent = amountOfDollars * rate;
        System.out.println("On " + dateRequested + " the exchange rate from USD to Euros is " +rate + ".");
        System.out.println("$" + amountOfDollars + " is equivalent to " + euroEquivalent + " Euros");
    }
    class RateResponse {
        public String base;
        public String date;
        public Rates rates;

    }
    class Rates {
        public double EUR;
    }
}
