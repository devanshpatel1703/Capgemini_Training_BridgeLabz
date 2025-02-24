import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class ModifyPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            System.out.println("Before modification: " + person);

            Class<?> clazz = person.getClass();
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);

            // Modifying the private field 'age'
            ageField.set(person, 30);
            System.out.println("After modification: " + person);

            // Retrieving the private field 'age'
            int age = (int) ageField.get(person);
            System.out.println("Retrieved age: " + age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
