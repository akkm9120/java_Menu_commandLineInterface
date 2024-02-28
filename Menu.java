public abstract class Menu {
  protected String name;
  protected String description;
  protected double price;

  public Menu() {
    name = "";
    description = "";
    price = 0.0;
  }

  public Menu(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  // Getter for 'name'
  public String getName() {
    return name;
  }

  // Setter for 'name'
  public void setName(String name) {
    this.name = name;
  }

  // Getter for 'description'
  public String getDescription() {
    return description;
  }

  // Setter for 'description'
  public void setDescription(String description) {
    this.description = description;
  }

  // Getter for 'price'
  public double getPrice() {
    return price;
  }

  // Setter for 'price'
  public void setPrice(double price) {
    this.price = price;
  }

  public String toString() {
    return "Menu => " + name + " <= . It is made up of " +
        description + " " +
        ". And the Price is (" + price + "$)";
  }

  public abstract double Netcost();
}
