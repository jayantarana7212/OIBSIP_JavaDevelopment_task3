import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private static Map<String, Account> accounts = new HashMap<>();

    static {
        // Predefined accounts for testing
        accounts.put("user1", new Account("user1", "1234", 500.0));
        accounts.put("user2", new Account("user2", "5678", 1000.0));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        Account account = accounts.get(userId);
        if (account != null && account.getPin().equals(pin)) {
            User user = new User(account);
            ATMService atmService = new ATMService(user, accounts); // Pass the accounts map
            atmService.showMenu();
        } else {
            System.out.println("Invalid User ID or PIN.");
        }

        scanner.close();
    }
}
