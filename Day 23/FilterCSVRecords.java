import java.io.*;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filename = "students.csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line != null) {
                System.out.println(line);
                System.out.println("-".repeat(40));
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]); 
                if (marks > 80) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
