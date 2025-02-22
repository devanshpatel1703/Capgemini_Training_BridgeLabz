import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceUtils {
   public String longRunningTask() {
       try {
           Thread.sleep(3000); 
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       }
       return "Task Completed";
   }
}

class PerformanceUtilsTest {
   private final PerformanceUtils performanceUtils = new PerformanceUtils();

   @Test
   @Timeout(value = 2, unit = TimeUnit.SECONDS) 
   void testLongRunningTaskTimeout() {
       performanceUtils.longRunningTask(); 
   }
}
