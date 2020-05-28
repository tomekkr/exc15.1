import java.math.BigDecimal;

class Product {
    private String name;
    private BigDecimal price;
    private BigDecimal tax;

    public Product(String name, BigDecimal price, BigDecimal tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

      public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                '}';
    }
}
