import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Adi{
    int var = 10;

    int var(){
        return var;
    }
}

public class MaxElementExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 1);

        Optional<Integer> maxElement = numbers.stream()
                                              .max(Integer::compareTo);

                                              var a = new Adi();


        maxElement.ifPresent(max -> System.out.println("The maximum element is: " + max + " " + a.var()));
    }
}