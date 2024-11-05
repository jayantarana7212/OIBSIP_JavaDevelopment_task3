import java.util.Map;
import java.util.Scanner;

public class ATMService {
    private User user;
    private Map<String, Account> accounts;

    // Constructor that takes User and a map of all accounts
    public ATMService(User user, Map<String, Account> accounts) {
        this.user = user;
        this.accounts = accounts;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Transaction History");
            System.out.println("5. Quit");
            System.out.println("6. Check Balance"); // New option for checking balance
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    user.getAccount().withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    user.getAccount().deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter recipient User ID: ");
                    String recipientId = scanner.next();
                    Account recipientAccount = findAccountByUserId(recipientId);
                    if (recipientAccount != null) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        user.getAccount().transfer(recipientAccount, transferAmount);
                    } else {
                        System.out.println("Recipient not found.");
                    }
                    break;
                case 4:
                    System.out.println("Transaction History:");
                    for (String transaction : user.getAccount().getTransactionHistory()) {
                        System.out.println(transaction);
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the ATM.");
                    break;
                case 6:
                    System.out.println("Current Balance: RS " + user.getAccount().getBalance()); // Show balance
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }

    // Find account by user ID from the provided accounts map
    private Account findAccountByUserId(String userId) {
        return accounts.get(userId); // Return account if found, otherwise null
    }
}
