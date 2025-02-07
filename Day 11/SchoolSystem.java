// Base class: Person
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass: Teacher
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age); // Call superclass constructor
        this.subject = subject;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade) {
        super(name, age); // Call superclass constructor
        this.grade = grade;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age); // Call superclass constructor
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Main class
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("John Doe", 40, "Mathematics");
        teacher.displayDetails();

        Student student = new Student("Alice", 15, 10);
        student.displayDetails();

        Staff staff = new Staff("Bob", 35, "Administration");
        staff.displayDetails();
    }
}