class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Define Department Class
// Composition Relationship with University
class Department {
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

// Define University Class
// Composition with Department and Aggregation with Faculty
class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Add a department to the university
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Add a faculty to the university
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Show all departments in the university
    public void showDepartments() {
        System.out.println("Departments at " + universityName + ":");
        for (Department department : departments) {
            System.out.println("- " + department.getDepartmentName());
        }
    }

    // Show all faculty members associated with the university
    public void showFaculties() {
        System.out.println("Faculty members at " + universityName + ":");
        for (Faculty faculty : faculties) {
            System.out.println("- " + faculty.getName());
        }
    }

    // Delete the university and its departments
    public void deleteUniversity() {
        System.out.println("Deleting University: " + universityName);
        departments.clear(); // Deleting departments (composition)
        faculties.clear();   // Faculty can remain outside (aggregation)
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        // Create a university
        University myUniversity = new University("GLA University");

        // Create departments
    // composition relationship
        Department cseDepartment = new Department("Computer Science Engineering");
        Department eeDepartment = new Department("Electrical Engineering");

        // Add departments to the university
        myUniversity.addDepartment(cseDepartment);
        myUniversity.addDepartment(eeDepartment);

        // Create faculty members
    // aggregation relationship
        Faculty ashutosh = new Faculty("Ashutosh Choubey");
        Faculty shardul = new Faculty("Shardul Kumbhar");

        // Add faculty members to the university
        myUniversity.addFaculty(ashutosh);
        myUniversity.addFaculty(shardul);

        // Display departments and faculties
        myUniversity.showDepartments();
        myUniversity.showFaculties();

        // Delete the university
    // composition deletes departments but not faculties
        myUniversity.deleteUniversity();

        // Check status after deletion
        myUniversity.showDepartments(); // Should be empty
        myUniversity.showFaculties();   // Faculty list cleared but theoretically could exist independently
    }
}