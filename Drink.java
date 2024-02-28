public class Drink extends Menu {
    protected String type;

    public Drink() {
        super();
        type = "";
    }

    public Drink(String name, String description, double price, String type) {
        super(name, description, price);
        this.type = type;
    }

    // Getter for 'type'
    public String getType() {
        return type;
    }

    // Setter for 'type'
    public void setType(String type) {
        this.type = type;
    }

    public double Netcost() {
        return price * 1.2;
    }

    public String toString() {
        String output = super.toString();
        return output + ". type " + type + " drink";
    }
}
