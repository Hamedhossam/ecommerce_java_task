public class Cart {
    private Product[] products;
    private int[] quantities;
    private int productCount;

    public Cart(int capacity) {
        products = new Product[capacity];
        quantities = new int[capacity];
        productCount = 0;
    }

    public void addProduct(Product product, int quantity) throws Exception {
        if (product == null) {
            throw new Exception("Product cannot be null");
        } else if (!product.isAvailable()) {
            throw new Exception("Product is Out of Stock for this product (" + product.getName() + ")");
        } else if (quantity <= 0) {
            throw new Exception("Quantity must be greater than zero");
        } else if (product.getQuantity() < quantity) {
            throw new Exception("Not enough stock available for this product (" + product.getName() + ")");
        } else if (productCount >= products.length) {
            throw new Exception("Cart is full");
        } else {
            products[productCount] = product;
            quantities[productCount] = quantity;
            productCount++;
        }
    }

    public String getShippingCost() throws Exception {
        double totalWeight = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i] instanceof NotExpiralbleAndShippableProduct) {
                totalWeight += ((NotExpiralbleAndShippableProduct) products[i]).getWeight() * quantities[i];
            } else if (products[i] instanceof ExpirableAndShippableProduct) {
                totalWeight += ((ExpirableAndShippableProduct) products[i]).getWeight() * quantities[i];
            }
        }
        if (totalWeight == 0) {
            throw new Exception("No shippable products in the cart");
        }
        return String.format("%.2f", totalWeight * 5.0); // Assuming shipping cost is $5 per kg
    }

    public boolean isEmpty() {
        return productCount == 0;
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice() * products[i].getQuantity();
        }
        return total;
    }

    public Product[] getProducts() {
        return products;
    }

    public int[] getQuantities() {
        return quantities;
    }

}
