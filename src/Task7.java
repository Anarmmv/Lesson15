import java.util.Arrays;
import java.util.Optional;

public class Task7 {
  public static Optional<Character> findFirstUniqueCharacter(String text){
      return  text.chars()
              .mapToObj(c->(char) c)
              .filter(c -> text.indexOf(c) == text.lastIndexOf(c))
              .findFirst();


  }

    static void main(String[] args) {
        Optional<Character> result = findFirstUniqueCharacter("swiss") ;
        Optional<Character> result1 = findFirstUniqueCharacter("hello") ;
        Optional<Character> result2 = findFirstUniqueCharacter("aabbcc") ;
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }


}
