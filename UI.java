import java.util.Scanner;

public class UI {
  Scanner sc = new Scanner(System.in);

  public int display() {
    System.out.println("\nWelcome to ToDoList: ");
    System.out.println("These are the Instructions: \n");
    System.out.println(" 1) Show all Menu List");
    System.out.println(" 2) Add a new Menu ");
    System.out.println(" 3) Update a Menu ");
    System.out.println(" 4) Delete a Menu ");
    System.out.println(" 5) Exit the Program ");
    System.out.print("\nPlease choose an option you want to perform : ");

    int input = sc.nextInt();
    sc.nextLine();

    
    return input;
  }
}
