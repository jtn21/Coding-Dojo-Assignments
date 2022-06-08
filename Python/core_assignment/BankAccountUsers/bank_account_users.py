
class User:
    def __init__(self, name):
        self.name = name
        self.account = BankAccount(int_rate=.02, balance = 0)

    def make_withdrawal( self, amount ):
        self.account.balance -= amount
    
    def make_deposit( self, amount):
        self.account.balance += amount

    def display_user_balance(self):
        print(f"User: {self.name}, Balance:{self.account.balance}")
    


class BankAccount:
    def __init__(self, int_rate, balance): 
        self.int_rate = int_rate
        self.balance = balance

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
        print(f"Balance: {self.balance}")
        return self
        
    def yield_interest(self):
        self.balance = (self.int_rate * self.balance) + self.balance
        return self

bob = User ( "bob" )
bob.make_deposit(10)
bob.make_deposit(10)
bob.make_deposit(10)
bob.make_withdrawal(10)
bob.display_user_balance()