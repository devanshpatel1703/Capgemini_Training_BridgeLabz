import java.io.*;
import java.util.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filename = "largefile.csv";
        int chunkSize = 100;
        int totalRecordsProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            List<String> batch = new ArrayList<>();
            
            while ((line = br.readLine()) != null) {
                batch.add(line);
                
                if (batch.size() == chunkSize) {
                    processBatch(batch);
                    totalRecordsProcessed += batch.size();
                    System.out.println("Processed " + totalRecordsProcessed + " records...");
                    batch.clear();  
                }
            }

            if (!batch.isEmpty()) { 
                processBatch(batch);
                totalRecordsProcessed += batch.size();
                System.out.println("Processed " + totalRecordsProcessed + " records...");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void processBatch(List<String> batch) {

        for (String line : batch) {
            System.out.println(line);
        }
    }
}
