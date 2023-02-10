from bank_account import BankAccount
class User:
    def __init__(self,name,email,age):
        self.name=name
        self.email=email
        self.age=age
        self.account=[BankAccount.accounts()]

n_account=BankAccount(1000)
nadhir=User('Nadhir','yezza.nadhir@gmail.com',36)
print(n_account.Bank_name,n_account.balance)
print(nadhir.account)