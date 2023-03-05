package sales;

public class Product extends Money {
    private String name;
    public Product(int fullPartCount, int hundredPartCount, String fullPartName, String hundredPartName, String productName) {
        super(fullPartCount, hundredPartCount, fullPartName, hundredPartName);
        this.name = productName;
    }
    public Product(int hundredPartCount, String fullPartName, String hundredPartName, String productName) {
        super(hundredPartCount, fullPartName, hundredPartName);
        this.name = productName;
    }

    public void decreasePrice(int hundredParts) {
        super.decreaseHundredPartCount(hundredParts);
    }

    @Override
    public String toString() {
        return String.format("Product %s with price %s", this.name, super.toString());
    }
}
