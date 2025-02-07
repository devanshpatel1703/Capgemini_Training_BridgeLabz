// Base class: BankAccount
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance); // Call superclass constructor
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance); // Call superclass constructor
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int tenure; // Tenure in years

    public FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance); // Call superclass constructor
        this.tenure = tenure;
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Tenure: " + tenure + " years");
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000, 4.5);
        savings.displayAccountDetails();

        CheckingAccount checking = new CheckingAccount("CA456", 3000, 1000);
        checking.displayAccountDetails();

        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD789", 10000, 5);
        fixedDeposit.displayAccountDetails();
    }
}