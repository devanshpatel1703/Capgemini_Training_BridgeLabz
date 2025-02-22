import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

public class PasswordValidator {
   public boolean isValid(String password) {
       if (password == null || password.length() < 8) {
           return false;
       }
       boolean hasUppercase = false;
       boolean hasDigit = false;

       for (char ch : password.toCharArray()) {
           if (Character.isUpperCase(ch)) {
               hasUppercase = true;
           }
           if (Character.isDigit(ch)) {
               hasDigit = true;
           }
       }

       return hasUppercase && hasDigit;
   }
}


class PasswordValidatorTest {
   private final PasswordValidator passwordValidator = new PasswordValidator();

   @ParameterizedTest
   @ValueSource(strings = {"Password1", "Secure123", "TestPass9"})
   void testValidPasswords(String password) {
       assertTrue(passwordValidator.isValid(password), password + " should be valid.");
   }

   @ParameterizedTest
   @ValueSource(strings = {"short1", "nocapital123", "NoDigitHere", "weak", ""})
   void testInvalidPasswords(String password) {
       assertFalse(passwordValidator.isValid(password), password + " should be invalid.");
   }

   @Test
   void testNullPassword() {
       assertFalse(passwordValidator.isValid(null), "Null password should be invalid.");
   }
}
