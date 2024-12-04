import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.readFromFile("indian_grocery_store.csv");

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nIndian Grocery Store Management System");
            System.out.println("1. Display All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Change Product Price");
            System.out.println("4. Remove Expired Products");
            System.out.println("5. Restock Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manager.displayAllProducts();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String name = input.nextLine();
                    System.out.print("Enter category: ");
                    String category = input.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = input.nextInt();
                    System.out.print("Enter price: ");
                    double price = input.nextDouble();
                    input.nextLine();
                    System.out.print("Enter expiry date (YYYY-MM-DD): ");
                    String expiryDate = input.nextLine();

                    manager.addProduct(new GroceryProduct(name, category, quantity, price, expiryDate));
                    break;
                case 3:
                    System.out.print("Enter product name: ");
                    String productName = input.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = input.nextDouble();

                    manager.changePrice(productName, newPrice);
                    break;
                case 4:
                    manager.removeExpiredProducts();
                    break;

                case 5:
                    System.out.print("Enter product name: ");
                    String restockProductName = input.nextLine();
                    System.out.print("Enter quantity to add: ");
                    int additionalQuantity = input.nextInt();
                    manager.restockProduct(restockProductName, additionalQuantity);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        input.close();
    }
}
