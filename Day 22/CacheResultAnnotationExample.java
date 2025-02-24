import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveComputation {

    private static final Map<String, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveMethod(int input) {
        String key = "input_" + input;

        if (cache.containsKey(key)) {
            System.out.println("Returning cached result for input " + input);
            return cache.get(key);
        }

        System.out.println("Computing result for input " + input);
        int result = input * input; 

        cache.put(key, result);

        return result;
    }
}

public class CacheResultAnnotationExample {

    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();

        System.out.println("Result: " + computation.expensiveMethod(5));
        System.out.println("Result: " + computation.expensiveMethod(3));
        System.out.println("Result: " + computation.expensiveMethod(5)); 
        System.out.println("Result: " + computation.expensiveMethod(3)); 
    }
}
