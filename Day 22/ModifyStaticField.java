import java.lang.reflect.Field;

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Configuration.class;

            Field apiKeyField = clazz.getDeclaredField("API_KEY");

            apiKeyField.setAccessible(true);

            apiKeyField.set(null, "new_api_key_12345");

            Configuration.printAPIKey();  

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
