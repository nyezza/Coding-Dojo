class User:
    def __init__(self,name,email):
        self.name= name
        self.email= email 
        self.account_balance=0
    def make_deposit(self,amount):
        if amount<0:
            print("there a prolem, you can't deposit a negativ amount")
        else:    
            self.account_balance += amount
        return self
    def make_withdrawal(self, amount):
        if amount<0:
            print("there a prolem, you can't withdrawal a negativ amount")
        else:
            self.account_balance -= amount
        return self
    def display_user_balance(self):
        print (f"User: {self.name}, Balance: ${self.account_balance}")
        
    def transfer_money(self, other_user, amount):
        other_user.make_deposit(amount)
        self.make_withdrawal(amount)
        self.display_user_balance()
        other_user.display_user_balance()
        
nadhir = User("Nadhir Yezza","yezza.nadhir@gmail.com")
aymen = User("Aymen", "aymen@gmail.com")
nouha = User("Nouha","nouha@gmail.com")

print(f" th user name is : {nadhir.name}")

nadhir.make_deposit(500)
print(f"the new balance after deposit {nadhir.account_balance}")

nadhir.make_withdrawal(1000)
print(f"the new balance after the withdrawal {nadhir.account_balance}")
nadhir.display_user_balance()


nadhir.make_deposit(100).make_deposit(100).make_deposit(100).make_withdrawal(200).display_user_balance()

aymen.make_deposit(100).make_deposit(100).make_withdrawal(200).display_user_balance()

nouha.make_deposit(100).make_withdrawal(-100).make_withdrawal(-200).display_user_balance()

nadhir.transfer_money(nouha,100)