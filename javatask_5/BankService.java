package javatask_5;

import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private int accountCounter = 1000;

    // Create Account
    public int createAccount(double initialBalance) throws InvalidAmountException {
        if (initialBalance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative");
        }

        int accountNumber = ++accountCounter;
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.put(accountNumber, account);

        return accountNumber;
    }

    // Get Account
    public BankAccount getAccount(int accountNumber) throws AccountNotFoundException {
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }

        return account;
    }

    // Deposit
    public void deposit(int accountNumber, double amount)
            throws AccountNotFoundException, InvalidAmountException {

        BankAccount account = getAccount(accountNumber);
        account.deposit(amount);
    }

    // Withdraw
    public void withdraw(int accountNumber, double amount)
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {

        BankAccount account = getAccount(accountNumber);
        account.withdraw(amount);
    }
}