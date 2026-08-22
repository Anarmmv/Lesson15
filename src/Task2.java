import java.util.List;
import java.util.Optional;

public class Task2 {
    static void main(String[] args) {


        List<Integer> numbers = List.of(12, 5, 87, 23, 45, 87, 3);

        Optional<Integer> max = numbers
                .stream()
                .max(Integer::compareTo);

        System.out.println("Max: " + max.orElseGet(()->{
            System.out.println("Deyer tapılmadı, default qaytarılır");
            return 0 ;
        }));

        Optional<Integer> min = numbers
                .stream()
                .min(Integer::compareTo);

        System.out.println("Min: " + min.orElseGet(()-> {
            System.out.println("Deyer tapılmadı, default qaytarılır");
            return 0;


        })) ;

    }
}