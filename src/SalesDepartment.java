import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class SalesDepartment {
    public static void main(String[] args) {
        String sourceFileName = "products.csv";
        File sourceFile = new File(sourceFileName);
        String statsFileName = "stats.txt";
        File statsFile = new File(statsFileName);

        try (Scanner fileScanner = new Scanner(sourceFile);
             FileWriter fileWriter = new FileWriter(statsFile)) {

            List<Product> products = DataReader.getProductsFromFile(fileScanner);
            fileWriter.write(SalesService.getSalesInfo(products));
            System.out.println(SalesService.getSalesInfo(products));

        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + sourceFileName);
        } catch (NumberFormatException e) {
            System.err.println("Niepoprawne dane w pliku " + sourceFileName);
        } catch (IOException e) {
            System.err.println("Wystąpił bład przy próbie utworzenia lub zmodyfikowania pliku " + statsFileName);
        }
    }
}
