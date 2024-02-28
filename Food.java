public class Food extends Menu {
    protected String cuisine;

    public Food() {
        super();
        cuisine = "";
    }

    public Food(String name, String description, double price, String cuisine) {
        super(name, description, price);
        this.cuisine = cuisine;
    }

    // Getter for 'cuisine'
    public String getCuisine() {
        return cuisine;
    }

    // Setter for 'cuisine'
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public double Netcost() {
        return price * 1.2;
    }

    public String toString() {
        String output = super.toString();
        return output + ". Cuisine " + cuisine;
    }
}
