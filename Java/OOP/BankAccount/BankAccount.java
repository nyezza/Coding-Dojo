public class BankAccount{
    

    // Attributes
    private double checkingBalance;
    private double savingBalance;

    // class member
    static int numberAccount = 0;
    static double totalAmount = 0;
    
    //constructor
    public BankAccount(){
        this.checkingBalance= 0;
        this.savingBalance=0;
        numberAccount =+1;
    }
    
    // Getter & Setter
    public double getCheckingBalance(){
        return checkingBalance;
    }


    public double getSavingBalance(){
        return savingBalance;
    }

    // Methods 

    public void depositMoney(BankAccount account, double amount ){
        account.savingBalance = +amount;
        totalAmount=+amount;
    }

    public void withdrawMoney(BankAccount account, double amount){
        if (account.savingBalance>amount){
            account.savingBalance =- amount;
            totalAmount =-amount;
        }
        else{
            System.out.println("you have insufficient funds ");
        }
    }

    public void displayTotalMoney(BankAccount account){
        System.out.println("at this moment you have : $"+account.savingBalance);
    }

    }
