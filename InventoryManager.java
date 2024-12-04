import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class InventoryManager implements InventoryActions {
    private List<GroceryProduct> products = new ArrayList<>();

    public void readFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine(); // Skip header
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                products.add(new GroceryProduct(
                        data[0].trim(), data[1].trim(), Integer.parseInt(data[2].trim()),
                        Double.parseDouble(data[3].trim()), data[4].trim()
                ));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void updateCSVFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Name,Category,Quantity,Price,ExpiryDate\n");
            for (GroceryProduct product : products) {
                writer.write(product.getName() + "," +
                        product.getCategory() + "," +
                        product.getQuantity() + "," +
                        product.getPrice() + "," +
                        product.getExpiryDate() + "\n");
            }
            System.out.println("Inventory updated in " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("Error updating inventory in CSV: " + e.getMessage());
        }
    }

    public void displayAllProducts() {
        System.out.printf("%-20s %-15s %-10s %-10s %-15s%n", "Name", "Category", "Quantity", "Price", "ExpiryDate");
        System.out.println("-----------------------------------------------------------------------------------");
        for (GroceryProduct product : products) {
            System.out.printf("%-20s %-15s %-10d %-10.2f %-15s%n",
                    product.getName(), product.getCategory(),
                    product.getQuantity(), product.getPrice(),
                    product.getExpiryDate());
        }
    }

    public void addProduct(GroceryProduct product) {
        products.add(product);
        System.out.println("Product added successfully!");
        updateCSVFile("indian_grocery_store.csv");
    }

    public void changePrice(String productName, double newPrice) {
        for (GroceryProduct product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.setPrice(newPrice);
                System.out.println("Price updated successfully!");
                updateCSVFile("indian_grocery_store.csv");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void removeExpiredProducts() {
        System.out.println("Removing Expired Products:");
        for (GroceryProduct product : products) {
            if (product.isExpired()) {
                product.displayDetails(); // Show details of the expired product
            }
        }
        products.removeIf(GroceryProduct::isExpired);
        System.out.println("Expired products removed.");
        updateCSVFile("indian_grocery_store.csv");
    }


    public void restockProduct(String productName, int additionalQuantity) {
        for (GroceryProduct product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.setQuantity(product.getQuantity() + additionalQuantity);
                System.out.println("Product restocked successfully!");
                updateCSVFile("indian_grocery_store.csv");
                return;
            }
        }
        System.out.println("Product not found.");
    }



}


