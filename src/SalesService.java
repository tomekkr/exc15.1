import java.math.BigDecimal;
import java.util.List;

class SalesService {
    private SalesService() {
    }

    public static void printSalesInfo(List<Product> products) {
        System.out.println("Sprzedaż Netto: " + sumNetPrices(products));
        System.out.println("Suma podatku VAT ze sprzedaży: " + sumTaxValues(products));
        System.out.println("Suma sprzedaży Brutto: " + sumGrossPrices(products));
    }

    private static BigDecimal sumNetPrices(List<Product> products) {
        BigDecimal netPriceSum = new BigDecimal("0");
        for (Product product : products) {
            netPriceSum = netPriceSum.add(product.getPrice());
        }
        return netPriceSum;
    }

    private static BigDecimal sumTaxValues(List<Product> products) {
        BigDecimal taxSum = new BigDecimal("0");
        for (Product product : products) {
            taxSum = taxSum.add(calculateTaxValue(product));
        }
        return taxSum;
    }

    private static BigDecimal sumGrossPrices(List<Product> products) {
        BigDecimal grossPriceSum = new BigDecimal("0");
        BigDecimal netPrice, grossPrice;
        for (Product product : products) {
            netPrice = product.getPrice();
            grossPrice = netPrice.add(calculateTaxValue(product));
            grossPriceSum = grossPriceSum.add(grossPrice);
        }
        return grossPriceSum;
    }

    private static BigDecimal calculateTaxValue(Product product) {
        BigDecimal tax;
        BigDecimal netPrice, taxValue;
        tax = product.getTax();
        netPrice = product.getPrice();
        taxValue = netPrice.multiply(tax.divide(new BigDecimal(100)));
        return taxValue;
    }
}
