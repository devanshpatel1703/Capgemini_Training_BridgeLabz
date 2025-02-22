import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverter {
   public double celsiusToFahrenheit(double celsius) {
       return (celsius * 9/5) + 32;
   }

   public double fahrenheitToCelsius(double fahrenheit) {
       return (fahrenheit - 32) * 5/9;
   }
}

class TemperatureConverterTest {
   private final TemperatureConverter converter = new TemperatureConverter();

   @Test
   void testCelsiusToFahrenheit() {
       assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.01, "0°C should be 32°F");
       assertEquals(100.0, converter.celsiusToFahrenheit(37.78), 0.01, "37.78°C should be 100°F");
       assertEquals(-40.0, converter.celsiusToFahrenheit(-40.0), 0.01, "-40°C should be -40°F");
   }

   @Test
   void testFahrenheitToCelsius() {
       assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.01, "32°F should be 0°C");
       assertEquals(37.78, converter.fahrenheitToCelsius(100.0), 0.01, "100°F should be 37.78°C");
       assertEquals(-40.0, converter.fahrenheitToCelsius(-40.0), 0.01, "-40°F should be -40°C");
   }
}
