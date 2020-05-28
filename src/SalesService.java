import java.math.BigDecimal;
import java.util.List;

class SalesService {
    private SalesService() {
    }

    public static String getSalesInfo(List<Product> products) {
        return "Sprzedaż Netto: " + sumNetPrices(products) +
                "\nSuma podatku VAT ze sprzedaży: " + sumTaxValues(products) +
                "\nSuma sprzedaży Brutto: " + sumGrossPrices(products);
    }

    private static BigDecimal sumNetPrices(List<Product> products) {
        BigDecimal netPriceSum = new BigDecimal("0");
        for (Product product : products) {
            netPriceSum = netPriceSum.add(product.getPrice());
        }
        return netPriceSum;
    }

    private static BigDecimal sumGrossPrices(List<Product> products) {
        BigDecimal grossPriceSum = new BigDecimal("0");
        for (Product product : products) {
            grossPriceSum = calculateGrossPrice(product);
        }
        return grossPriceSum;
    }

    private static BigDecimal sumTaxValues(List<Product> products) {
        BigDecimal taxSum = new BigDecimal("0");
        for (Product product : products) {
            taxSum = taxSum.add(calculateTaxValue(product));
        }
        return taxSum;
    }

    private static BigDecimal calculateTaxValue(Product product) {
        BigDecimal tax = product.getTax();
        BigDecimal netPrice = product.getPrice();
        return netPrice.multiply(tax.divide(new BigDecimal(100)));
    }

    private static BigDecimal calculateGrossPrice(Product product) {
        BigDecimal netPrice = product.getPrice();
        BigDecimal tax = calculateTaxValue(product);
        return netPrice.add(tax);
    }
}
