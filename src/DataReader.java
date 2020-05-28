import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {
    private DataReader() {
    }

    public static List<Product> getProductsFromFile(Scanner scanner) {
        List<Product> products = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> elements = List.of(line.split(";"));
            products.add(new Product(elements.get(0), new BigDecimal(elements.get(1)), new BigDecimal(elements.get(2))));
        }
        return products;
    }
}
