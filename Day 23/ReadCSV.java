import java.io.*;
import java.util.*;

public class ReadCSV {
    public static void main(String[] args) {
        String filename = "students.csv"; 
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line != null) {
                System.out.println(line);
                System.out.println("-".repeat(40));
            }
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
