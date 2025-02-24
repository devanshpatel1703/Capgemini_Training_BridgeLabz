import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Object studentObject = constructor.newInstance("John Doe", 21);
            
            Student student = (Student) studentObject;
            student.displayInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
