package Task9;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {
    static void main(String[] args) {

        Product laptop = new Product(1L, "Laptop", new BigDecimal(2500));
        Product mouse = new Product(2L, "Mouse", new BigDecimal(40));
        Product keyboard = new Product(3L, "Keyboard", new BigDecimal(90));


        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, 100L, List.of(
                new OrderItem(laptop, 2),
                new OrderItem(mouse, 5)
        )));
        orders.add(new Order(2L, 101L, List.of(
                new OrderItem(laptop, 3),
                new OrderItem(keyboard, 20)
        )));
        orders.add(new Order(3L, 102L, List.of(
                new OrderItem(mouse, 30),
                new OrderItem(keyboard, 40)
        )));


        List<Product> distinctProducts = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getProduct)
                .distinct()
                .toList();


        Optional<Product> mostSoldProduct = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.groupingBy(OrderItem::getProduct, Collectors.summingInt(OrderItem::getQuantity)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);





        Map<Product, BigDecimal> totalSales = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.groupingBy(
                        OrderItem::getProduct,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                orderItem -> orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()))
                                ,BigDecimal::add
                        )
                ));

        Optional<Product> highestRevenueProduct = totalSales.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey) ;


        System.out.println(distinctProducts);
        System.out.println(mostSoldProduct);
        System.out.println(totalSales);
        System.out.println(highestRevenueProduct);




    }
}
