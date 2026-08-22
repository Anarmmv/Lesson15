package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {


        List<User> users = List.of(
                new User(1L, "Vusal", true, 25),
                new User(2L, "Aysel", false, 30),
                new User(3L, "Kamran", true, 22),
                new User(4L, "Narmin", true, 28),
                new User(5L, "Elvin", false, 19)
        );
        List<String> activeUsers = users
                .stream()
                .filter(User::isActive)
                .map(User::getName)
                .sorted()
                .collect(Collectors.toList());

        activeUsers.forEach(System.out::println);

    }
}
