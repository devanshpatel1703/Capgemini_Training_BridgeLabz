// Base class: Course
class Course {
    protected String courseName;
    protected int duration; // Duration in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); // Call superclass constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Is Recorded: " + isRecorded);
    }
}

// Subclass: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded); // Call superclass constructor
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + (fee - (fee * discount / 100)));
    }
}

// Main class
public class CourseSystem {
    public static void main(String[] args) {
        Course course = new Course("Java Programming", 30);
        course.displayCourseDetails();

        OnlineCourse onlineCourse = new OnlineCourse("Python Programming", 20, "Udemy", true);
        onlineCourse.displayCourseDetails();

        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Java", 40, "Coursera", true, 200, 10);
        paidCourse.displayCourseDetails();
    }
}