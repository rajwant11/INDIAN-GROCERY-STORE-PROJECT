public class GroceryProduct extends Product {
    public GroceryProduct(String name, String category, int quantity, double price, String expiryDate) {
        super(name, category, quantity, price, expiryDate);
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName() +
                ", Category: " + getCategory() +
                ", Quantity: " + getQuantity() +
                ", Price: $" + getPrice() +
                ", Expiry Date: " + getExpiryDate());
    }
}
