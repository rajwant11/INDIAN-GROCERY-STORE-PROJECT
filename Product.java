import java.time.LocalDate;

public abstract class Product {
    private String name;
    private String category;
    private int quantity;
    private double price;
    private String expiryDate;

    public Product(String name, String category, int quantity, double price, String expiryDate) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    // Abstract method for subclasses to define their own display behavior
    public abstract void displayDetails();

    // Method to check if the product is expired
    public boolean isExpired() {
        LocalDate expiry = LocalDate.parse(expiryDate);
        return expiry.isBefore(LocalDate.now());
    }

    // Getters for private variables
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    // Setters if needed (optional)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
