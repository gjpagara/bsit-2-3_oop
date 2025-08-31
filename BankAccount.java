public class BankAccount {
    static String bankName = "Liceo Bank";
    static int totalAccounts = 0;
    static double interestRate = 0.03;

    private static int accountNumberGenerator = 1000;

    public static String generateAccountNumber() {
        return "LB" + (accountNumberGenerator++);
    }

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₱" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₱" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public void displayAccountInfo() {
        System.out.println("=== Account Information ===");
        System.out.println("Bank: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₱" + balance);
        System.out.println("Interest (3%): ₱" + calculateInterest());
        System.out.println();


    }
}
