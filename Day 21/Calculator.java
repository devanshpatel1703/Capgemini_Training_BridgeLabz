import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Calculator {
   public int add(int a, int b) {
       return a + b;
   }

   public int subtract(int a, int b) {
       return a - b;
   }

   public int multiply(int a, int b) {
       return a * b;
   }

   public int divide(int a, int b) {
       if (b == 0) {
           throw new ArithmeticException("Division by zero is not allowed.");
       }
       return a / b;
   }
}
class CalculatorTest {
       private Calculator calculator;
       @BeforeEach
       void setup() {
           calculator = new Calculator();
       }

       @Test
       void testAddition() {
       assertEquals(5, calculator.add(2, 3));
       assertEquals(-1, calculator.add(-2, 1));
       assertEquals(0, calculator.add(0, 0));
   }

   @Test
   void testSubtraction() {
       assertEquals(1, calculator.subtract(3, 2));
       assertEquals(-3, calculator.subtract(-2, 1));
       assertEquals(0, calculator.subtract(5, 5));
   }

   @Test
   void testMultiplication() {
       assertEquals(6, calculator.multiply(2, 3));
       assertEquals(-2, calculator.multiply(-2, 1));
       assertEquals(0, calculator.multiply(0, 5));
   }

   @Test
   void testDivision() {
       assertEquals(2, calculator.divide(6, 3));
       assertEquals(-2, calculator.divide(-6, 3));
       assertEquals(0, calculator.divide(0, 5));
   }

   @Test
   void testDivisionByZero() {
       Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
       assertEquals("Division by zero is not allowed.", exception.getMessage());
   }
}
