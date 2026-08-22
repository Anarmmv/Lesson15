package Task10;

import java.util.List;

public class Account {
    private Long id;
    private List<Transaction> transactions;

    public Account(Long id, List<Transaction> transactions) {
        this.id = id;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
