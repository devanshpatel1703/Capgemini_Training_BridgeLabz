import java.lang.annotation.*;
import java.lang.reflect.Field;
import com.google.gson.Gson;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name(); // Custom JSON field name
}

class User {
    @JsonField(name = "user_name")
    private String username;
    
    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                String key = annotation.name();
                Object value = field.get(obj);

                json.append("\"").append(key).append("\": \"").append(value).append("\"");

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }
        }
        json.append("}");
        return json.toString();
    }
}

public class JsonFieldAnnotationExample {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Alice", 30);
        
        // Serialize user object to JSON string
        String jsonString = JsonSerializer.toJson(user);
        System.out.println(jsonString);
    }
}
