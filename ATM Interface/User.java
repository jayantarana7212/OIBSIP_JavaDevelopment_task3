public class User {
    private Account account;

    public User(Account account) {
        this.account = account;
    }

    public boolean validateCredentials(String userId, String pin) {
        return account.getUserId().equals(userId) && account.getPin().equals(pin);
    }

    public Account getAccount() {
        return account;
    }
}
