import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadInputAndWriteToFile {
    public static void main(String[] args) {
        String fileName = "output.txt";
        
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(fileName)) {
            
            String line;
            System.out.println("Enter text (type 'exit' to stop):");
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line + System.lineSeparator());
            }
            
            System.out.println("Input has been written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
