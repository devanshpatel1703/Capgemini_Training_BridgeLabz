import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnection {
   private boolean connected;

   public void connect() {
       connected = true;
       System.out.println("Database connected.");
   }

   public void disconnect() {
       connected = false;
       System.out.println("Database disconnected.");
   }

   public boolean isConnected() {
       return connected;
   }
}


class DatabaseConnectionTest {
   private DatabaseConnection dbConnection;

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
   void testConnectionEstablished() {
       assertTrue(dbConnection.isConnected(), "Database should be connected.");
   }

   @Test
   void testConnectionClosed() {
       dbConnection.disconnect();
       assertFalse(dbConnection.isConnected(), "Database should be disconnected.");
   }
}
