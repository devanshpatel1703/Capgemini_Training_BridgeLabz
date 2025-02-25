import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String filename = "employees.csv";
        String[] employees = {
            "ID,Name,Department,Salary",
            "201,Alice Johnson,HR,50000",
            "202,Robert Brown,IT,70000",
            "203,Emily Davis,Finance,65000",
            "204,Michael Wilson,Marketing,60000",
            "205,Sophia Martinez,Sales,55000"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String employee : employees) {
                bw.write(employee);
                bw.newLine();
            }
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
