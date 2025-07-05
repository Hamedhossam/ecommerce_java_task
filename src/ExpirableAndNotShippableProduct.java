public class ExpirableAndNotShippableProduct extends Product {
    final private String expirationDate;

    public ExpirableAndNotShippableProduct(String name, double price, double quantity, String expirationDate)
            throws Exception {
        super(name, price, quantity);
        if (expirationDate != null && expirationDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            this.expirationDate = expirationDate;
        } else {
            throw new Exception("Expiration date must be in format Like (2002-09-16)");
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

}
