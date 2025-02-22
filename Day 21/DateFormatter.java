import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatter {
   private final SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
   private final SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

   public String formatDate(String inputDate) throws ParseException {
       if (inputDate == null || inputDate.isEmpty()) {
           throw new IllegalArgumentException("Input date cannot be null or empty");
       }
       Date date = inputFormat.parse(inputDate);
       return outputFormat.format(date);
   }
}

class DateFormatterTest {
   private final DateFormatter dateFormatter = new DateFormatter();

   @Test
   void testValidDateFormat() throws ParseException {
       assertEquals("22-02-2025", dateFormatter.formatDate("2025-02-22"), "Date should be formatted correctly.");
       assertEquals("31-12-2020", dateFormatter.formatDate("2020-12-31"), "Date should be formatted correctly.");
   }

   @Test
   void testInvalidDateFormat() {
       assertThrows(ParseException.class, () -> dateFormatter.formatDate("2025/02/22"), "Should throw ParseException for invalid date format.");
       assertThrows(ParseException.class, () -> dateFormatter.formatDate("02-22-2025"), "Should throw ParseException for invalid date format.");
   }

   @Test
   void testNullOrEmptyDate() {
       assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate(null), "Should throw IllegalArgumentException for null date.");
       assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate(""), "Should throw IllegalArgumentException for empty date.");
   }
}
