import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistration {
   public void registerUser(String username, String email, String password) {
       if (username == null || username.trim().isEmpty()) {
           throw new IllegalArgumentException("Username cannot be null or empty.");
       }
       if (email == null || !isValidEmail(email)) {
           throw new IllegalArgumentException("Invalid email address.");
       }
       if (password == null || password.length() < 8) {
           throw new IllegalArgumentException("Password must be at least 8 characters long.");
       }
       // Registration logic (e.g., save user) would go here.
   }

   private boolean isValidEmail(String email) {
       // Basic regex for email validation
       String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
       return Pattern.matches(emailRegex, email);
   }
}

class UserRegistrationTest {
   private final UserRegistration userRegistration = new UserRegistration();

   @Test
   void testValidUserRegistration() {
       assertDoesNotThrow(() -> userRegistration.registerUser("john_doe", "john.doe@example.com", "SecurePass123"));
   }

   @Test
   void testInvalidUsername() {
       assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "john.doe@example.com", "SecurePass123"), "Username cannot be null or empty.");
       assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(null, "john.doe@example.com", "SecurePass123"), "Username cannot be null or empty.");
   }

   @Test
   void testInvalidEmail() {
       assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "invalid-email", "SecurePass123"), "Invalid email address.");
       assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", null, "SecurePass123"), "Invalid email address.");
   }

   @Test
   void testInvalidPassword() {
       assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "john.doe@example.com", "short"), "Password must be at least 8 characters long.");
       assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "john.doe@example.com", null), "Password must be at least 8 characters long.");
   }
}
