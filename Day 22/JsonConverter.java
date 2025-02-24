import java.lang.reflect.Field;

public class JsonConverter {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        try {
            Class<?> clazz = obj.getClass();
            
            Field[] fields = clazz.getDeclaredFields();
            boolean first = true;

            for (Field field : fields) {
                field.setAccessible(true);  
                
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);

                if (!first) {
                    json.append(", ");
                }
                first = false;

                json.append("\"").append(fieldName).append("\": ");

                if (fieldValue == null) {
                    json.append("null");
                } else if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else {
                    json.append(fieldValue);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        Person person = new Person("John Doe", 30, "Engineer");

        String jsonRepresentation = toJson(person);

        System.out.println(jsonRepresentation);
    }
}

class Person {
    private String name;
    private int age;
    private String profession;

    public Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }
}
