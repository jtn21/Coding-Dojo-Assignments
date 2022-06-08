
class User:
    def __init__(self, name):
        self.name = name
        self.amount = 0

    def make_withdrawal( self, amount ):
        self.amount -= amount
    
    def make_deposit( self, amount):
        self.amount += amount

    def display_user_balance(self):
        print(f"User: {self.name}, Balance:{self.amount}")
    




bob = User ( "bob" )
bob.make_deposit(10)
bob.make_deposit(10)
bob.make_deposit(10)
bob.make_withdrawal(10)
bob.display_user_balance()


sara = User ( "sara" )
sara.make_deposit(20)
sara.make_deposit(30)
sara.make_withdrawal(5)
sara.make_withdrawal(15)
sara.display_user_balance()

jack = User ( "jack")
jack.make_deposit(100)
jack.make_withdrawal(20)
jack.make_withdrawal(20)
jack.make_withdrawal(20)
jack.display_user_balance()


