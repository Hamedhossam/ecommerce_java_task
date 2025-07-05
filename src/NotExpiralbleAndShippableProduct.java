public class NotExpiralbleAndShippableProduct extends Product {
    private double weight;

    public NotExpiralbleAndShippableProduct(String name, double price, double quantity, double weight)
            throws Exception {
        super(name, price, quantity);
        if (weight < 0) {
            throw new Exception("Weight cannot be negative");
        } else {
            this.weight = weight;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws Exception {
        if (weight < 0) {
            throw new Exception("Weight cannot be negative");
        } else {
            this.weight = weight;
        }
    }

}
