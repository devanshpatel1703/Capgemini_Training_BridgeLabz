import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

class TaskManagerTest {
    
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fails if execution takes >2 seconds
    void testLongRunningTaskTimeout() throws InterruptedException {
        TaskManager taskManager = new TaskManager();
        String result = taskManager.longRunningTask();
        assertEquals("Task Completed", result);
    }
}
