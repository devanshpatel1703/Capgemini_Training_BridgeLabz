import java.util.ArrayList;
import java.util.List;

// Define Course Class
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " has been assigned to " + courseName);
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this); // Maintain bidirectional relationship
            System.out.println("Student " + student.getName() + " has enrolled in " + courseName);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }

    public Professor getProfessor() {
        return professor;
    }
}

// Define Student Class
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void showEnrolledCourses() {
        System.out.println(name + " is enrolled in the following courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}

// Define Professor Class
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void teachCourse(Course course) {
        course.assignProfessor(this);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create courses
        Course maths = new Course("Mathematics");
        Course cs = new Course("Computer Science");

        // Create students
        Student riya = new Student("Riya");
        Student yash = new Student("Yash");

        // Create professors
        Professor abhay = new Professor("Abhay Agrawal");
        Professor sant = new Professor("Santosh");

        // Assign professors to courses
        abhay.teachCourse(maths);
        sant.teachCourse(cs);

        // Enroll students in courses
        maths.enrollStudent(riya);
        maths.enrollStudent(yash);
        cs.enrollStudent(yash);

        // Show course details
        maths.showEnrolledStudents();
        cs.showEnrolledStudents();

        // Show student course enrollments
        riya.showEnrolledCourses();
        yash.showEnrolledCourses();
    }
}
