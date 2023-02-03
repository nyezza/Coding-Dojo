class BankAcount:
    accounts=[]
    @classmethod
    def __init__(self,int_rate,balance):
        self.int_rate = int_rate
        self.balance= balance
        BankAcount.accounts.append(self)
class User:
    def __init__(self,name):
        self.name= name
        self.account=BankAcount.accounts
    
    # def make_deposit():
        

nadhir=User("Nadhir")

nac=BankAcount(0.02,0)

# print(isinstance(nac,BankAcount))
print(nadhir.account)



