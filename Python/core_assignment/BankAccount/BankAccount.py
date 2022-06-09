class BankAccount:

    bank_name= "First National Dojo"
    all_accounts = []

    def __init__(self, int_rate, balance): 
        self.int_rate = int_rate
        self.balance = balance
        BankAccount.all_accounts.append(self)

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if amount > self.balance:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        else: self.balance -= amount
        return self

    def display_account_info(self):
        print(f"Balance: {self.balance} Interest rate is: {self.int_rate}")
        return self
        
    def yield_interest(self):
        self.balance = (self.int_rate * self.balance) + self.balance
        return self

    @classmethod
    def all_balances(cls):
        for account in cls.all_accounts:
            print(account.balance)


account1 = BankAccount(.05, 100)
account1.deposit(20).deposit(20).deposit(20).withdraw(40).yield_interest().display_account_info()


account2 = BankAccount (.1, 1000)
account2.deposit(200).deposit(100).withdraw(50).withdraw(50).withdraw(50).withdraw(50).yield_interest().display_account_info()

BankAccount.all_balances()