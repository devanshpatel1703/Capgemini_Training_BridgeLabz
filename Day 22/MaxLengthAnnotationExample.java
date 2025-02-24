import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            MaxLength maxLengthAnnotation = field.getAnnotation(MaxLength.class);
            if (maxLengthAnnotation != null && username.length() > maxLengthAnnotation.value()) {
                throw new IllegalArgumentException("Username exceeds maximum length of " + maxLengthAnnotation.value());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthAnnotationExample {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe"); 
            System.out.println("User created with username: " + user1.getUsername());

            User user2 = new User("VeryLongUsername"); 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
