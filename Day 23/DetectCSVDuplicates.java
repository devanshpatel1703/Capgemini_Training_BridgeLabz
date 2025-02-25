import java.io.*;
import java.util.*;

public class DetectCSVDuplicates {
    public static void main(String[] args) {
        String filename = "students.csv";
        Set<Integer> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();  
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);

                if (seenIds.contains(id)) {
                    duplicates.add(line);
                } else {
                    seenIds.add(id);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records:");
                for (String duplicate : duplicates) {
                    System.out.println(duplicate);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
