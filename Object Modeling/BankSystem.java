import java.util.*;
class Bank {
   private String name;
   private List<Customer> customers;

   public Bank(String name) {
       this.name = name;
       this.customers = new ArrayList<>();
   }

   public void openAccount(String customerName, int accountNumber, double initialBalance) {
       Customer customer = new Customer(customerName, this);
       customer.addAccount(new Account(accountNumber, initialBalance, this));
       customers.add(customer);
       System.out.println("Account opened successfully for " + customerName);
   }
}
class Customer {
   String name;
   Bank bank;
   List<Account> accounts;

   public Customer(String name, Bank bank) {
       this.name = name;
       this.bank = bank;
       this.accounts = new ArrayList<>();
   }

   public void addAccount(Account account) {
       accounts.add(account);
   }

   public void viewBalance(int accountNumber) {
       for (Account acc : accounts) {
           if (acc.getAccountNumber() == accountNumber) {
               System.out.println("Balance for account " + accountNumber + ": " + acc.getBalance());
               return;
           }
       }
       System.out.println("Account not found.");
   }
}

class Account {
   int accountNumber;
   double balance;
   Bank bank;

   public Account(int accountNumber, double balance, Bank bank) {
       this.accountNumber = accountNumber;
       this.balance = balance;
       this.bank = bank;
   }

   public int getAccountNumber() {
       return accountNumber;
   }

   public double getBalance() {
       return balance;
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter bank name: ");
       String bankName = sc.nextLine();
       Bank bank = new Bank(bankName);
       System.out.print("Enter customer name: ");
       String customerName = sc.nextLine();
       System.out.print("Enter account number: ");
       int accountNumber = sc.nextInt();
       System.out.print("Enter initial balance: ");
       double initialBalance = sc.nextDouble();
       bank.openAccount(customerName, accountNumber, initialBalance);
       Customer customer = new Customer(customerName, bank);
       customer.addAccount(new Account(accountNumber, initialBalance, bank));

       System.out.print("Enter account number to view balance: ");
       int viewAccount = sc.nextInt();
       customer.viewBalance(viewAccount);
   }
}