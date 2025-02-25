import java.io.*;
import java.sql.*;

public class GenerateCSVReport {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String dbUser = "your_username";
        String dbPassword = "your_password";
        String outputFile = "employee_report.csv";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            stmt = conn.createStatement();
            String query = "SELECT employee_id, name, department, salary FROM employees";
            rs = stmt.executeQuery(query);

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            String header = "Employee ID,Name,Department,Salary";
            bw.write(header);
            bw.newLine();

            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                String record = employeeId + "," + name + "," + department + "," + salary;
                bw.write(record);
                bw.newLine();
            }

            bw.close();
            System.out.println("CSV report generated: " + outputFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
