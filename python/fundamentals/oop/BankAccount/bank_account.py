
class BankAccount:
    Bank_name='BIAT'
    accounts=[]
    account_default_id=0
    def __init__(self,balance=0,int_rate=0.02):
        BankAccount.account_default_id += 1
        self.id= BankAccount.account_default_id
        self.balance=balance
        self.int_rate=int_rate
        BankAccount.accounts.append(self)
    def deposit(self, amount):
        self.balance += amount
        return self
    def withdraw(self, amount):
        if self.balance < amount:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        else:
            self.balance -= amount
        return self
    def display_account_info(self):
        print(f"The Balance: {self.balance}")
        return self
    def yield_interest(self):
        if self.balance>0:
            self.balance += (self.balance * self.int_rate)
        return self
    @classmethod
    def change_bank(cls, new_bank):
        cls.Bank_name=new_bank
    