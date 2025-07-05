public class ExpirableAndShippableProduct extends Product {
    final private String expirationDate;
    private double weight;

    public ExpirableAndShippableProduct(String name, double price, double quantity, String expirationDate,
            double weight) throws Exception {
        super(name, price, quantity);
        if (expirationDate != null && expirationDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            this.expirationDate = expirationDate;
        } else {
            throw new Exception("Expiration date must be in format Like (2002-09-16)");
        }
        if (weight < 0) {
            throw new Exception("Weight cannot be negative");
        } else {
            this.weight = weight;
        }
    }

    public boolean isExpired() {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
        java.time.LocalDate expDate = java.time.LocalDate.parse(expirationDate, formatter);
        java.time.LocalDate today = java.time.LocalDate.now();
        return expDate.isBefore(today);
    }

    public String getExpirationDate() {
        return expirationDate;
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
