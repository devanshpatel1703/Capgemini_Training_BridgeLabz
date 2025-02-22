import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

class DatabaseConnection {
    void connect() {
        System.out.println("Database connected");
    }

    void disconnect() {
        System.out.println("Database disconnected");
    }
}

class NumberUtils {
    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

class PerformanceTest {
    static void longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
    }
}

class FileProcessor {
    static void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    static String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}

public class DatabaseConnectionTest {
    DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnection() {
        assertNotNull(dbConnection);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    void testIsEven(int number) {
        boolean expected = number % 2 == 0;
        assertEquals(expected, NumberUtils.isEven(number));
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() throws InterruptedException {
        PerformanceTest.longRunningTask();
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String filename = "testfile.txt";
        String content = "Hello, World!";
        FileProcessor.writeToFile(filename, content);
        assertEquals(content, FileProcessor.readFromFile(filename));
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        String filename = "testfile.txt";
        FileProcessor.writeToFile(filename, "Sample Content");
        Path path = Paths.get(filename);
        assertTrue(Files.exists(path));
    }

    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
    }
}
