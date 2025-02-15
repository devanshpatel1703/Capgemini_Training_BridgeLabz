import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertByteStreamToCharStream {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
