public class Account {
    String accountNumber;
    String accountName;
    int balance;

    public Account(String number, String name, int bal) {
        accountNumber = number;
        accountName = name;
        balance = bal;
    }

    public void showAccount() {
        System.out.println("Account: " + accountNumber + ", Name: " + accountName + ", Balance: " + balance);
    }
}

