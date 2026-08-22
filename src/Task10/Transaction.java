package Task10;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transaction {
    private Long id;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime date;

    public Transaction(Long id, TransactionType type,
                       BigDecimal amount, LocalDateTime date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
