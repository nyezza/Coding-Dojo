class BankAccount:
    costumers_account=[]
    def __init__(self, int_rate, balance): 
        self.int_rate=0.01
        self.balance=0
        BankAccount.costumers_account.append(self)
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
    def Account_inventory(cls):
        for ac in cls.costumers_account:
            ac.display_account_info()

nadhir_account= BankAccount(0.01,0)
nouha_account=BankAccount(0.01,0)

nadhir_account.deposit(100).deposit(100).deposit(1000).withdraw(200).yield_interest().display_account_info()
nouha_account.deposit(100).deposit(100).withdraw(50).withdraw(50).withdraw(100).withdraw(100).yield_interest().display_account_info()

BankAccount.Account_inventory()