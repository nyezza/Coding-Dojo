public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        
        System.out.println(BankAccount.numberAccount);

        account1.depositMoney(account1, 200);
        account1.displayTotalMoney(account1);
        account2.depositMoney(account2, 300);
        account2.withdrawMoney(account2, 100);
    }
}
