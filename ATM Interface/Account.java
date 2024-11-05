import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    public Account(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account toAccount, double amount) {
        if (amount <= balance) {
            withdraw(amount);
            toAccount.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + toAccount.getUserId());
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
