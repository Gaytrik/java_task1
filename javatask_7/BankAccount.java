package javatask_7;

class BankAccount {
    private int balance = 1000;

    // synchronized method
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw " + amount);

        // wait until balance is sufficient
        while (balance < amount) {
            System.out.println("Insufficient balance... waiting");
            try {
                wait(); // thread waits
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Balance: " + balance);
    }

    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " depositing " + amount);

        balance += amount;

        System.out.println("Deposit done. Balance: " + balance);

        notify(); // wake up waiting thread
    }
}