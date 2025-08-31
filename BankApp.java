public class BankApp {
    public static void main(String[] args) {
    BankAccount acc1 = new BankAccount("Garry Pagara", 10000);
    BankAccount acc2 = new BankAccount("Jason Pagara", 13000);
    BankAccount acc3 = new BankAccount("Natoy Pangandaman", 9000);  // Third account

    acc1.deposit(3000);
    acc1.withdraw(1000);
    acc1.displayAccountInfo();

    acc2.withdraw(2000);
    acc2.deposit(1500);
    acc2.displayAccountInfo();

    acc3.withdraw(9000);
    acc3.deposit(3000);
    acc3.displayAccountInfo();

    System.out.println("Total accounts created: " + BankAccount.totalAccounts);
}
}
