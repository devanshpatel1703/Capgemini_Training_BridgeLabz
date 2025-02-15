import java.io.*;
import java.nio.charset.StandardCharsets;

public class StringAndFileOperations {
    public static void main(String[] args) {
        measureStringConcatenation();
        countWordsInFile("largefile.txt");
    }
    
    private static void measureStringConcatenation() {
        int iterations = 1_000_000;
        String sampleText = "hello";
        
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(sampleText);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");
        
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(sampleText);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
    
    private static void countWordsInFile(String fileName) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            System.out.println("Total words in file: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
