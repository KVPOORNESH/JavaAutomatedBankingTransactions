public class Transaction {
    public static synchronized void deposit(Account acc, int amount) {
        acc.balance += amount;
        System.out.println(acc.accountName + " deposited " + amount);
        acc.showAccount();
    }

    public static synchronized void withdraw(Account acc, int amount) {
        if (acc.balance >= amount) {
            acc.balance -= amount;
            System.out.println(acc.accountName + " withdrew " + amount);
        } else {
            System.out.println("Not enough balance for withdrawal!");
        }
        acc.showAccount();
    }

    public static synchronized void transfer(Account from, Account to, int amount) {
        if (from.balance >= amount) {
            from.balance -= amount;
            to.balance += amount;
            System.out.println(from.accountName + " transferred " + amount + " to " + to.accountName);
        } else {
            System.out.println("Transfer failed, not enough balance!");
        }
        from.showAccount();
        to.showAccount();
    }
}


