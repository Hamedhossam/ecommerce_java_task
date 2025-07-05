public class Customer {
    final private String name;
    private double balance;
    Cart cart;

    public Customer(String name, double balance) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Name cannot be null or empty");
        } else {
            this.name = name;
        }
        if (balance < 0) {
            throw new Exception("Balance cannot be negative");
        } else {
            this.balance = balance;
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws Exception {
        if (balance < 0) {
            throw new Exception("Balance cannot be negative");
        } else {
            this.balance = balance;
        }
    }

    public void checkout() throws Exception {
        if (cart == null || cart.isEmpty()) {
            throw new Exception("Cart is empty");
        }
        double total = cart.calculateTotal();
        if (total > balance) {
            throw new Exception("Insufficient balance cant checkout, total: " + total + ", your balance: " + balance);
        } else {
            balance -= total;
            System.out.println("** Checkout receipt **");
            for (int i = 0; i < cart.getProducts().length - 1; i++) {
                System.err.println(cart.getQuantities()[i] + "x " + cart.getProducts()[i].getName() + "        "
                        + cart.getProducts()[i].getPrice() * cart.getQuantities()[i]);

            }
            System.out.println("-----------------------------------");
            System.out.println("Subtotal: " + total);
            System.out.println("Shipping cost: " + cart.getShippingCost());
            System.out.println("Total: " + (total + Double.parseDouble(cart.getShippingCost())));
            System.out.println("-----------------------------------");
            System.out.println("Customer: " + name);
            System.out.println("Remaining balance: " + balance);
            System.out.println("** End of receipt **");
            cart = null;
        }
    }

}
