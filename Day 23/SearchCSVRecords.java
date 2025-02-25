import java.io.*;
import java.util.Scanner;

public class SearchCSVRecords {
    public static void main(String[] args) {
        String filename = "employees.csv"; 
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); 

            while ((String line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
