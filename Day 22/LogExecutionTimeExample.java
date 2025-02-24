import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(2000); // Simulate a slow method by sleeping for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @LogExecutionTime
    public void fastMethod() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(test); // Execute the method
                long endTime = System.nanoTime();
                
                long executionTime = endTime - startTime;
                System.out.println("Execution time of method " + method.getName() + ": " + executionTime + " nanoseconds");
            }
        }
    }
}
