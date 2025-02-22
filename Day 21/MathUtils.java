import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtils {
   public int divide(int a, int b) {
       if (b == 0) {
           throw new ArithmeticException("Division by zero is not allowed.");
       }
       return a / b;
   }
}

class MathUtilsTest {
   private final MathUtils mathUtils = new MathUtils();

   @Test
   void testDivisionByZero() {
       Exception exception = assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0));
       assertEquals("Division by zero is not allowed.", exception.getMessage());
   }

   @Test
   void testValidDivision() {
       assertEquals(2, mathUtils.divide(6, 3));
       assertEquals(-2, mathUtils.divide(-6, 3));
       assertEquals(0, mathUtils.divide(0, 5));
   }
}
