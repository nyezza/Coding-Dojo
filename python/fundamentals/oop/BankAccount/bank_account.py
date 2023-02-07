class BankAccount:
    Bank_name='BIAT'
    accounts=[]
    account_default_id=0
    def __init__(self,balance,int_rate):
        BankAccount.account_default_id += 1
        self.id= BankAccount.account_default_id
        self.balance=0
        self.int_rate=0.02
        BankAccount.accounts.append(self)
        