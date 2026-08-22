package Task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static Optional<Product> findMostExpensiveProduct(List<Product> products) {
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice));


    }

    public static Optional<String> findMostExpensiveProductName(List<Product> products) {
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .map(Product::getName);

    }

    public static Optional<Product> findMostExpensiveElectronics(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equals("ELECTRONICS"))
                .max(Comparator.comparingDouble(Product::getPrice));

    }


    static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1L, "Laptop", 1500, "ELECTRONICS"));
        products.add(new Product(2L, "Phone", 900, "ELECTRONICS"));
        products.add(new Product(3L, "Table", 500, "FURNITURE"));
        products.add(new Product(4L, "Door", 2000, "FURNITURE"));
        products.add(new Product(5L, "Chair", 300, "FURNITURE"));




        Optional<Product> result =
                findMostExpensiveProduct(products);

        System.out.println(result);

        Optional<Product> electronics =
                findMostExpensiveElectronics(products);

        System.out.println(electronics);

        Optional<String> name =
                findMostExpensiveProductName(products);

        System.out.println(name);


    }
}