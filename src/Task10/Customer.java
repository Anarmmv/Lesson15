package Task10;

import java.util.List;

public class Customer {

        private Long id;
        private String name;
        private List<Account> accounts;

        public Customer(Long id, String name, List<Account> accounts) {
            this.id = id;
            this.name = name;
            this.accounts = accounts;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Account> getAccounts() {
            return accounts;
        }
    }

