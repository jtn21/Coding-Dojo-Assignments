class User:
    def __init__(self, name):
        self.name = name
        self.amount = 0

    def make_withdrawal( self, amount ):
        self.amount -= amount
        return self
    
    def make_deposit( self, amount):
        self.amount += amount
        return self

    def display_user_balance(self):
        print(f"User: {self.name}, Balance:{self.amount}")
    




bob = User ( "bob" )
bob.make_deposit(10).make_deposit(10).make_deposit(10).make_withdrawal(10).display_user_balance()



sara = User ( "sara" )
sara.make_deposit(20).make_deposit(30).make_deposit(30).make_withdrawal(5).make_withdrawal(15).display_user_balance()


jack = User ( "jack")
jack.make_deposit(100).make_withdrawal(20).make_withdrawal(20).make_withdrawal(20).display_user_balance()
