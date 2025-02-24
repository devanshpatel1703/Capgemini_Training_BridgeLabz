import java.lang.reflect.Method;

public class MethodExecutionTiming {

    public static void measureExecutionTime(Object target, String methodName, Class<?>[] parameterTypes, Object[] args) {
        try {

            Method method = target.getClass().getMethod(methodName, parameterTypes);

            long startTime = System.nanoTime();

            method.invoke(target, args);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println("Execution time of " + methodName + ": " + duration + " nanoseconds.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        
        measureExecutionTime(myClass, "sayHello", new Class<?>[]{String.class}, new Object[]{"Alice"});
        
        measureExecutionTime(myClass, "calculateSum", new Class<?>[]{int.class, int.class}, new Object[]{5, 10});
    }
}

class MyClass {

    public void sayHello(String name) {
        try {
            Thread.sleep(500);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, " + name);
    }

    public int calculateSum(int a, int b) {
        try {
            Thread.sleep(300);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }
}
