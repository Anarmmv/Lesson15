package Task9;

import java.util.List;

public class Order {
    private Long id;
    private Long customerId;
    private List<OrderItem> items;

    public Order(Long id, Long customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
