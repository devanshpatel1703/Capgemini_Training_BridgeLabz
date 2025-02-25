import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv"; 
        String file2 = "students2.csv"; 
        String outputFile = "merged_students.csv"; 

        Map<Integer, String[]> studentsData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine(); 
            String line;
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                studentsData.put(id, data);
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file1 + ": " + e.getMessage());
            return;
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String header = "ID,Name,Age,Marks,Grade";
            bw.write(header);
            bw.newLine();

            br2.readLine(); 
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                if (studentsData.containsKey(id)) {
                    String[] student = studentsData.get(id);
                    String mergedRecord = String.join(",", student[0], student[1], student[2], data[1], data[2]);
                    bw.write(mergedRecord);
                    bw.newLine();
                }
            }

            System.out.println("Merged CSV file created as " + outputFile);
        } catch (IOException e) {
            System.out.println("Error reading " + file2 + " or writing the merged file: " + e.getMessage());
        }
    }
}
