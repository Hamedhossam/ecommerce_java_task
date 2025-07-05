public class Product {
    private String name;
    private double price;
    private double quantity;

    public Product(String name, double price, double quantity)
            throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Name cannot be null or empty");
        } else {
            this.name = name;

        }
        if (price < 0) {
            System.out.println("Price cannot be negative, it will be the default (0)");
            this.price = 0;
        } else {
            this.price = price;
        }
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative, it will be the default (0)");
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }

    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be null or empty");
        } else {
            this.name = name;
        }
    }

    public void setQuantity(double quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative");
        } else {
            this.quantity = quantity;
        }
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Price cannot be negative");
        } else {
            this.price = price;
        }
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

}
