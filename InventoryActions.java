public interface InventoryActions {
    // Method to read inventory data from a file
    void readFromFile(String fileName);

    // Method to display all products in the inventory
    void displayAllProducts();

    // Method to add a new product to the inventory
    void addProduct(GroceryProduct product);

    // Method to change the price of a product
    void changePrice(String productName, double newPrice);

    // Method to remove expired products from the inventory
    void removeExpiredProducts();

    // Method to restock a specific product
    void restockProduct(String productName, int additionalQuantity);
}
