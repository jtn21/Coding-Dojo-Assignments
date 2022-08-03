public class BankAccount {

    //Member variables
        private double checkingBalance;
        private double savingsBalance;

        private static int numberOfAccounts = 0;
        private static double totalBalance;


    //constructor
    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
        totalBalance = this.checkingBalance + this.savingsBalance;
        
    }

    //getters & setters

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }


    public double getTotalBalance(){
        return this.totalBalance;
    }

    public void setTotalBalance(){
        this.totalBalance = totalBalance;
    }

    
    //methods

    public double depositChecking(double amount){
        this.checkingBalance += amount;
        return this.checkingBalance;
    }

    public double depositSaving(double amount){
        this.savingsBalance += amount;
        return this.savingsBalance;
    }

    public double withdrawChecking(double amount){
        if(this.checkingBalance == 0){
            System.out.println ("You broke");
        }else if (amount > this.checkingBalance){
            System.out.println ("Insufficient Funds");
        }else {
            this.checkingBalance -= amount;
            return this.checkingBalance;
        }
        return this.checkingBalance;
    }


}