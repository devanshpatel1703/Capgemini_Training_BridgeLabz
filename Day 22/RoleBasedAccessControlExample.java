import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value(); // Role allowed to access the method
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class AdminPanel {

    @RoleAllowed("ADMIN")
    public void accessAdminPanel() {
        System.out.println("Access granted to Admin Panel.");
    }

    public void accessGeneralPanel() {
        System.out.println("Access granted to General Panel.");
    }
}

public class RoleBasedAccessControlExample {

    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User guestUser = new User("GUEST");
        
        AdminPanel panel = new AdminPanel();
        
        try {
            System.out.println("Admin trying to access:");
            invokeMethodIfAllowed(panel, "accessAdminPanel", adminUser);
            
            System.out.println("\nGuest trying to access:");
            invokeMethodIfAllowed(panel, "accessAdminPanel", guestUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethodIfAllowed(Object obj, String methodName, User user) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName);
        
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (roleAllowed.value().equals(user.getRole())) {
                method.invoke(obj);
            } else {
                System.out.println("Access Denied! Insufficient permissions.");
            }
        } else {
            method.invoke(obj);
        }
    }
}
