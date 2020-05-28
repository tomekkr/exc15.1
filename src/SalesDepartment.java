import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class SalesDepartment {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Telewizor", new BigDecimal("100"), new BigDecimal("23")));
        products.add(new Product("Praliny", new BigDecimal("40"), new BigDecimal("8")));
        products.add(new Product("Thinking in Java", new BigDecimal("120"), new BigDecimal("5")));

        SalesService.printSalesInfo(products);
    }
}
