class BankAccount:
    # don't forget to add some default values for these parameters!
    def __init__(self, int_rate, balance): 
        self.int_rate = int_rate
        self.balance = balance
        # your code here! (remember, instance attributes go here)
        # don't worry about user info here; we'll involve the User class soon

    def deposit(self, amount):
        # your code here
        self.balance += amount
        return self

    def withdraw(self, amount):
        # your code here
        if amount > self.balance:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        else: self.balance -= amount
        return self

    def display_account_info(self):
        print(f"Balance: {self.balance}")
        return self
    #     # your code here

    def yield_interest(self):
    #     # your code here
        self.balance = (self.int_rate * self.balance) + self.balance
        return self

account1 = BankAccount(.05, 100)
account1.deposit(20).deposit(20).deposit(20).withdraw(40).yield_interest().display_account_info()


account2 = BankAccount (.1, 1000)
account2.deposit(200).deposit(100).withdraw(50).withdraw(50).withdraw(50).withdraw(50).yield_interest().display_account_info()