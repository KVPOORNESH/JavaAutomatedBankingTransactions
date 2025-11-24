import java.util.ArrayList;

public class Bank {
    ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public Account findAccount(String accNum) {
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accNum)) return acc;
        }
        return null;
    }
}

