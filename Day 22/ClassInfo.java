import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInfo {
    public static void main(String[] args) {
        try {
            System.out.print("Enter the class name: ");
            String className = System.console().readLine();
            Class<?> clazz = Class.forName(className);
            System.out.println("Class: " + clazz.getName());

            Constructor<?>[] constructors = clazz.getConstructors();
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println(field);
            }

            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
