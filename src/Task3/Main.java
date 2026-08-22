package Task3;

import java.util.List;


public class Main {
    static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Laptop", 1500.0, true),
                new Product("Phone", 800.0, true),
                new Product("Monitor", 300.0, true),
                new Product("Mouse", 25.0, true),
                new Product("Keyboard", 90.0, false),
                new Product("TV", 1200.0, false)
        );

        List<String> aviableProducts = products
                .stream()
                .filter(product -> product.getPrice() > 100 && product.isAvailable())
                .sorted((p1,p2)->(int)(p1.getPrice()-p2.getPrice()))
                .map(Product::getName)
                .toList();


        System.out.println(aviableProducts);
    }
}
