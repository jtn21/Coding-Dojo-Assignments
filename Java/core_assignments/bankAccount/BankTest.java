public class BankTest {
    public static void main(String[] args){

        System.out.println("----Bank Account Test----");

        BankAccount account1 = new BankAccount(1000, 5000);

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        System.out.println(account1.getTotalBalance());

        System.out.println("----Deposit Test----");
        System.out.println(account1.depositChecking(10));
        System.out.println(account1.depositSaving(10));
        System.out.println(account1.getCheckingBalance());

        System.out.println("----Withdraw Test----");
        System.out.println(account1.withdrawChecking(2000));
        System.out.println(account1.withdrawChecking(200));
    }
}