package javatask_7;

public class ThreadDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        WithdrawThread t1 = new WithdrawThread(account);
        DepositThread t2 = new DepositThread(account);

        t1.start();
        t2.start();
    }
}