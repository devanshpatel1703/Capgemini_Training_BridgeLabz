import java.io.*;

public class CountCSVRows {
    public static void main(String[] args) {
        String filename = "employees.csv"; 
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); 
            while (br.readLine() != null) {
                count++;
            }
            System.out.println("Total records: " + count);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
