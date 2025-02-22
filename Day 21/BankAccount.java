import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccount {
   private double balance;

   public BankAccount(double initialBalance) {
       if (initialBalance < 0) {
           throw new IllegalArgumentException("Initial balance cannot be negative");
       }
       this.balance = initialBalance;
   }

   public void deposit(double amount) {
       if (amount <= 0) {
           throw new IllegalArgumentException("Deposit amount must be positive");
       }
       balance += amount;
   }

   public void withdraw(double amount) {
       if (amount <= 0) {
           throw new IllegalArgumentException("Withdrawal amount must be positive");
       }
       if (amount > balance) {
           throw new IllegalArgumentException("Insufficient funds");
       }
       balance -= amount;
   }

   public double getBalance() {
       return balance;
   }
}


class BankAccountTest {
   private BankAccount account;

   @BeforeEach
   void setUp() {
       account = new BankAccount(100.0); // Initial balance is 100
   }

   @Test
   void testDeposit() {
       account.deposit(50.0);
       assertEquals(150.0, account.getBalance(), 0.01, "Balance should be updated correctly after deposit.");
   }

   @Test
   void testWithdraw() {
       account.withdraw(40.0);
       assertEquals(60.0, account.getBalance(), 0.01, "Balance should be updated correctly after withdrawal.");
   }

   @Test
   void testWithdrawInsufficientFunds() {
       Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
       assertEquals("Insufficient funds", exception.getMessage());
   }

   @Test
   void testDepositNegativeAmount() {
       Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
       assertEquals("Deposit amount must be positive", exception.getMessage());
   }

   @Test
   void testWithdrawNegativeAmount() {
       Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
       assertEquals("Withdrawal amount must be positive", exception.getMessage());
   }

   @Test
   void testInitialNegativeBalanceThrowsException() {
       Exception exception = assertThrows(IllegalArgumentException.class, () -> new BankAccount(-50.0));
       assertEquals("Initial balance cannot be negative", exception.getMessage());
   }
}
