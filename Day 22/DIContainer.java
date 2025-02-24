import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class SimpleDIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void register(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }

    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();

        for (Field field : targetClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();

                if (instances.containsKey(fieldType)) {
                    Object dependency = instances.get(fieldType);

                    field.setAccessible(true);
                    try {
                        field.set(target, dependency);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}

class Car {
    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}

public class DIContainer {
    public static void main(String[] args) {
        SimpleDIContainer diContainer = new SimpleDIContainer();

        diContainer.register(Engine.class, new Engine());
        diContainer.register(Car.class, new Car());

        Car car = new Car();

        diContainer.injectDependencies(car);

        car.drive();
    }
}
