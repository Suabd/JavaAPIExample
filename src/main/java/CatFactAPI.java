import kong.unirest.Unirest;

public class CatFactAPI {
    public static void main(String[] args) {
        String url = "https://catfact.ninja/fact";
        CatFact catFact = Unirest.get(url).asObject(CatFact.class).getBody();
        System.out.println(catFact.getFact());
        // Can you also print the length data from the API response
        int factLength = catFact.getLength();;
        System.out.println("The fact is " + factLength + " characters long");


    }
}

class CatFact {
    private String fact;
    private int length;

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
