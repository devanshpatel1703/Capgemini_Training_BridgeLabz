import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}