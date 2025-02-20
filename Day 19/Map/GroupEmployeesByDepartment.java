import java.util.*;

class Employee {
    String name, department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class GroupEmployeesByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Alice", "HR"),
                                                 new Employee("Bob", "IT"),
                                                 new Employee("Carol", "HR"));

        Map<String, List<Employee>> departmentMap = new HashMap<>();
        for (Employee e : employees) {
            departmentMap.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        System.out.println(departmentMap);
    }
}