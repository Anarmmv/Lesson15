package Task8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static Map<String, BigDecimal> totalBalanceByType(
            List<Account> accounts) {
        return accounts.stream()
                .filter(Account::isActive)
                .collect(Collectors.groupingBy(
                        Account::getType,
                        Collectors.reducing(BigDecimal.ZERO, Account::getBalance, BigDecimal::add)));


    }

    public static Optional<String> highestBalanceType(List<Account> accounts) {
        return totalBalanceByType(accounts)
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);


    }
    public static  Optional<List<Long>>customersWithBalanceOver1000(List<Account> accounts){
        return Optional.of(accounts.stream()
                .filter(Account::isActive)
                .filter(account -> account.getBalance().compareTo(BigDecimal.valueOf(1000)) > 0)
                .map(Account::getCustomerId)
                .distinct()
                .toList());

    }

    static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(
                1L, 101L, "DEBIT",
                new BigDecimal("1500"), true));

        accounts.add(new Account(
                2L, 102L, "CREDIT",
                new BigDecimal("800"), true));

        accounts.add(new Account(
                3L, 103L, "SAVINGS",
                new BigDecimal("3000"), true));

        accounts.add(new Account(
                4L, 101L, "SAVINGS",
                new BigDecimal("2000"), true));

        accounts.add(new Account(
                5L, 104L, "DEBIT",
                new BigDecimal("500"), false));

        accounts.add(new Account(
                6L, 105L, "CREDIT",
                new BigDecimal("2000"), true));

        accounts.add(new Account(
                7L, 103L, "DEBIT",
                new BigDecimal("1200"), true));


        Map<String, BigDecimal> total =
                totalBalanceByType(accounts);

        System.out.println("Type uzre umumi balans:");
        System.out.println(total);



        Optional<String> highest =
                highestBalanceType(accounts);

        System.out.println("En yuksek umumi balansa sahib type:");
        System.out.println(highest);



        Optional<List<Long>> customerIds =
                customersWithBalanceOver1000(accounts);

        System.out.println("1000 AZN-den çox balansı olan customerId-lər:");
        System.out.println(customerIds);
    }

}
