public class Dessert extends Menu {
  protected String type;

  public Dessert() {
    super();
    type = "";
  }

  public String getType() {
      return type;
  }

  public void setType(String type){
    this.type = type;
  }
  
  public Dessert(String name, String description, double price, String type) {
    super(name, description, price);
    this.type = type;
  }
  
  public double Netcost(){
    return price*1.2;
  }
}