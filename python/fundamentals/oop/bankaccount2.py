class BankAcount:
    accounts=[]
    def __init__(self,int_rate,balance):
        self.name=User.name
        self.int_rate = User.rate
        self.balance= User.account_balance
        BankAcount.accounts.append(self)
    
    
class User:
    user_account = BankAcount.accounts
    @classmethod
    def __init__(self,name,account_balance,rate):
        self.name= name
        self.account_balance={
            "dep":0,
            "dra":0
            }
        self.rate=rate
        self.total_balance= self.account_balance['dep'] - self.account_balance['dra']
    def deposit(self, amount):
        self.account_balance['dep'] += amount
        self.total_balance += amount
        return self
    def withdraw(self, amount):
        
        if self.total_balance < amount:
            print("Insufficient funds: Charging a $5 fee")
            self.total_balance -= 5
        else:
            self.account_balance['dra'] += amount
            self.total_balance -= amount
        return self
    def display_account_info(self):
        print(f"The depos Balance of {self.name} is: {self.account_balance['dep']}")
        print(f"The draw Balance of {self.name} is: {self.account_balance['dra']}")
        print(f"the total balance is : {self.total_balance}")
        return self
    def yield_interest(self):
        
        if self.total_balance>0:
            self.total_balance += (self.total_balance* self.rate)
        return self
    @classmethod
    def Account_inventory(cls):
        for ac in cls.user_account:
            ac.display_account_info()

nadhir=User("nadhir",0,0.02)
nadhir.deposit(100).deposit(100).deposit(1000).withdraw(200).yield_interest().display_account_info()
nadhir.Account_inventory()





