import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FileProcessor {
   public void writeToFile(String filename, String content) throws IOException {
       Files.write(Path.of(filename), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
   }

   public String readFromFile(String filename) throws IOException {
       return Files.readString(Path.of(filename));
   }
}

class FileProcessorTest {
   private final FileProcessor fileProcessor = new FileProcessor();
   private final String testFile = "testfile.txt";

   @BeforeEach
   void setUp() throws IOException {
       Files.deleteIfExists(Path.of(testFile)); // Ensure test file is removed before each test
   }

   @AfterEach
   void tearDown() throws IOException {
       Files.deleteIfExists(Path.of(testFile)); // Clean up after tests
   }

   @Test
   void testWriteAndReadFromFile() throws IOException {
       String content = "Hello, JUnit!";
       fileProcessor.writeToFile(testFile, content);

       assertTrue(Files.exists(Path.of(testFile)), "File should exist after writing.");
       String readContent = fileProcessor.readFromFile(testFile);
       assertEquals(content, readContent, "Content read from file should match written content.");
   }

   @Test
   void testReadFromNonExistentFileThrowsException() {
       assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
   }
}
