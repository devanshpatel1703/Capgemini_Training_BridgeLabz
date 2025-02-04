class BankAccount{
    static String bankName="Unknown Bank";
    static int instance=0;
    String accountHolderName="Unknown Account";
    final int accountNumber;
    public BankAccount(String bankName,String accountHolderName,int accountNumber){
        setBankName(bankName);
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        instance++;

    }
    public static void setBankName(String bank){
        bankName=bank;
    }
    public void getTotalAccounts(){
        System.out.println("Total Accounts :"+instance);
    }
    public void displayAccount(){
        System.out.println(bankName+"--"+accountHolderName+"--"+accountNumber);
    }
    public static void main(String[] args) {
        BankAccount obj=new BankAccount("SBI","Dev",1234);
        BankAccount obj1=new BankAccount("SBI","Dev",1234);
        BankAccount obj2=new BankAccount("SBI","Dev",1234);
        BankAccount obj3=new BankAccount("SBI","Dev",1234);
        BankAccount obj4=new BankAccount("SBI","Dev",1234);
        obj3.displayAccount();
        obj2.getTotalAccounts();
    }
}