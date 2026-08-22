import Task1.User;

import java.util.List;
import java.util.Optional;


public class Task4 {

     public static Optional<User> findUserById(List<User> users,long id){
         return users.stream()
                 .filter(user -> user.getId().equals(id))
                 .findFirst() ;
     }
    public static String getUserNameById(List<User> users, Long id) {
        Optional<User> user = findUserById(users, id);

        return user.map(User::getName)
                .orElseGet(() -> "Unknown User");


     }

    static void main() {
        List<User> users = List.of(
                new User(1L, "Vusal", true, 25),
                new User(2L, "Aysel", false, 30),
                new User(3L, "Kamran", true, 22)
        );

        Optional<User> user = findUserById(users, 2L) ;
        System.out.println(user);
        Optional<User> notFound = findUserById(users, 5L);
        System.out.println(notFound);

        String name1 = getUserNameById(users, 3L);
        String name2 = getUserNameById(users, 4L);
        System.out.println(name1);
        System.out.println(name2);
    }

}

