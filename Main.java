import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Menu> menu;
    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        UI ui = new UI();

        menu = new ArrayList<Menu>();
        sc = new Scanner(System.in);
        int input=0;
        do {
          try {
                  input = ui.display();
                  switch (input) {

                      case 1:
                          // show all menu
                          System.out.print("\033[H\033[2J");
                          System.out.println("Here is the Menu List :");
                          for (Menu m : menu) {
                              System.out.println(m);
                          }
                          break;
                      case 2:
                          // Add a new Menu
                          addnewMenu();
                          break;
                      case 3:
                          // Update a Menu
                          updateMenu();
                          break;
                      case 4:
                          deleteMenu();
                          break;
                      default:
                          System.out.println("Invalid Input!");
                  }
              } catch (Exception e) {
                  System.out.println("Invalid Input!");
                  sc.nextLine(); // Clearing the input buffer
              }
          } while (input != 5);
        System.out.print("\033[H\033[2J");
        System.out.println("Exiting program. Goodbye!");
    }

    public static void addnewMenu() {
        System.out.print("\033[H\033[2J");
        System.out.println("Add New menu Item :");
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.println("Enter a short description : ");
        String description = sc.nextLine();
        System.out.print("Enter price : ");
        double price = sc.nextDouble();
        sc.nextLine();

        Menu newMenu = null;

        System.out.print("Is it Food (F) or Drink (D) : ");
        String userInput = sc.next().toLowerCase();
        sc.nextLine();

        if (userInput.equals("f")) {
            System.out.println("Enter food's cuisine : ");
            String cuisine = sc.nextLine();
          
            System.out.print("\033[H\033[2J");
            newMenu = new Food(name, description, price, cuisine);
        } 
        else if (userInput.equals("d")) {
          
            System.out.println("Enter the type of the drink (alcohol/non-alcohol)");
            String type = sc.nextLine();
            System.out.print("\033[H\033[2J");
            newMenu = new Drink(name, description, price, type);
        } else {
          
            System.out.println("Wrong Input!");
            System.out.println("Closing console...");
            // Exit the Java program
            System.exit(0);
        }
        menu.add(newMenu);
    }

    public static void updateMenu() {
        System.out.print("\033[H\033[2J");
        System.out.println("Update Menu Item :");
        System.out.print("Enter the name of the menu item to update: ");
        String nameToUpdate = sc.nextLine();
      
        int updateIndex = searchByName(nameToUpdate);
      
        if (updateIndex != -1) {
            Menu menuToUpdate = menu.get(updateIndex);
            System.out.print("Enter Name [" + menuToUpdate.getName() + "]: ");
            String name = sc.nextLine();
            name = name.isEmpty() ? menuToUpdate.getName() : name;

            System.out.print("Enter a short description [" + menuToUpdate.getDescription() + "]: ");
            String description = sc.nextLine();
            description = description.isEmpty() ? menuToUpdate.getDescription() : description;

            System.out.print("Enter price [" + menuToUpdate.getPrice() + "]: ");
          
            double price;
            try {
                price = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                price = menuToUpdate.getPrice();
            }

            if (menuToUpdate instanceof Food) {
              
                Food foodToUpdate = (Food) menuToUpdate;
                System.out.print("Enter food's cuisine [" + foodToUpdate.getCuisine() + "]: ");
                String cuisine = sc.nextLine();
                cuisine = cuisine.isEmpty() ? foodToUpdate.getCuisine() : cuisine;
              
                menu.set(updateIndex, new Food(name, description, price, cuisine));
            } 
            else if (menuToUpdate instanceof Drink) {
              
                Drink drinkToUpdate = (Drink) menuToUpdate;
                System.out.print("Enter the type of the drink (alcohol/non-alcohol) [" + drinkToUpdate.getType() + "]: ");
                String type = sc.nextLine();
                type = type.isEmpty() ? drinkToUpdate.getType() : type;
                menu.set(updateIndex, new Drink(name, description, price, type));
            }
            System.out.println("Menu item updated successfully!");
        } else {
            System.out.println("Menu item not found!");
        }
    }

    public static void deleteMenu() {
      System.out.print("\033[H\033[2J");
      System.out.println("Delete a Menu Item :");
      System.out.print("Enter the name of item to Delete: ");
      String nameToDelete = sc.nextLine();
      
      int Index = searchByName(nameToDelete);
      
      menu.remove(Index); 
      
      try {
          Thread.sleep(1500); 
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      
      System.out.print("The targeted item has been deleted! \n");
      
    }



  
    public static int searchByName(String nameToUpdate) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getName().equalsIgnoreCase(nameToUpdate))             {
                return i;
            }
        }
        return -1;
    }
}
