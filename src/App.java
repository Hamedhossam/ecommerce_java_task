public class App {
    public static void main(String[] args) throws Exception {
        Product mobileScratch = new Product("mobileScratch", 200, 7);
        ExpirableAndShippableProduct cheese = new ExpirableAndShippableProduct("Cheddar Cheese", 150, 5, "2025-07-10",
                0.5);
        ExpirableAndNotShippableProduct biscuits = new ExpirableAndNotShippableProduct("Chocolate Biscuits", 30, 10,
                "2025-08-01");
        NotExpiralbleAndShippableProduct tv = new NotExpiralbleAndShippableProduct("Smart TV 55-inch", 500, 2, 15.0);
        Customer customer = new Customer("Hamed", 4000.00);
        Cart myCart = new Cart(5);
        myCart.addProduct(mobileScratch, 1);
        myCart.addProduct(cheese, 2);
        myCart.addProduct(biscuits, 3);
        myCart.addProduct(tv, 1);
        customer.cart = myCart;
        customer.checkout();
    }
}
