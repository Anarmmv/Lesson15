package Task8;

import java.math.BigDecimal;

public class Account {

    private Long id;
    private Long customerId;
    private String type;
    private BigDecimal balance;
    private boolean active;

    public Account(Long id, Long customerId, String type,
                   BigDecimal balance, boolean active) {

        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return customerId + " - " + type + " - " + balance;
    }
}