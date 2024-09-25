import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) { balance = initialBalance; }
    public double getBalance() { return balance; }
    public void deposit(double amount) { if (amount > 0) balance += amount; }
    public void withdraw(double amount) { if (amount > 0 && amount <= balance) balance -= amount; }
}

class ATM {
    private BankAccount account;
    public ATM(BankAccount account) { this.account = account; }
    public void displayMenu() { System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit"); }
    public void checkBalance() { System.out.println("Balance: " + account.getBalance()); }
    public void deposit(double amount) { account.deposit(amount); }
    public void withdraw(double amount) { account.withdraw(amount); }
}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get initial balance from user
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);

        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> atm.checkBalance();
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                }
                case 4 -> {
                    System.out.println("Thank You!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
