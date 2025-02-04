class Student {
    static String universityName = "Unknown University";  
    static int totalStudents = 0;  

    String name;
    final int rollNumber;  
    String grade;

    public Student(String name, int rollNumber, String grade, String university) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        setUniversityName(university);
        totalStudents++;  
    }

    public static void setUniversityName(String university) {
        universityName = university;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayStudentInfo() {
        System.out.println(name + " | Roll No: " + rollNumber + " | Grade: " + grade + " | " + universityName);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 101, "A", "XYZ University");
        Student s2 = new Student("Bob", 102, "B", "XYZ University");

        if (s1 instanceof Student) {
            s1.displayStudentInfo();
        }
        if (s2 instanceof Student) {
            s2.displayStudentInfo();
        }

        displayTotalStudents();
    }
}
