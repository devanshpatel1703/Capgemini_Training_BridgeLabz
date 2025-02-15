import java.io.*;

public class CountWordOccurences {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String targetWord = "word";
        int count = 0;
        
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
            
            System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
