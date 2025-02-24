import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

class LoggingProxy implements InvocationHandler {
    private Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Calling method: " + method.getName());
        return method.invoke(target, args);
    }

    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new LoggingProxy(target)
        );
    }
}

public class LogginProxy {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();

        Greeting proxyGreeting = (Greeting) LoggingProxy.createProxy(greeting);

        proxyGreeting.sayHello("Alice");
        proxyGreeting.sayHello("Bob");
    }
}
