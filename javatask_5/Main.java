package javatask_5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();

        while (true) {
            System.out.println("\n===== Banking System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter initial balance: ");
                        double initialBalance = sc.nextDouble();

                        int accNo = bankService.createAccount(initialBalance);
                        System.out.println("Account created! Account Number: " + accNo);
                        break;

                    case 2:
                        System.out.print("Enter account number: ");
                        int accNoDep = sc.nextInt();

                        System.out.print("Enter amount to deposit: ");
                        double depAmount = sc.nextDouble();

                        bankService.deposit(accNoDep, depAmount);
                        System.out.println("Deposit successful!");
                        break;

                    case 3:
                        System.out.print("Enter account number: ");
                        int accNoWith = sc.nextInt();

                        System.out.print("Enter amount to withdraw: ");
                        double withAmount = sc.nextDouble();

                        bankService.withdraw(accNoWith, withAmount);
                        System.out.println("Withdrawal successful!");
                        break;

                    case 4:
                        System.out.print("Enter account number: ");
                        int accNoCheck = sc.nextInt();

                        double balance = bankService.getAccount(accNoCheck).getBalance();
                        System.out.println("Current Balance: " + balance);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (AccountNotFoundException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }
}