import java.util.ArrayList;
import java.util.Scanner;

// Represents a bank account
class Account {
    String accountNumber;
    String accountName;
    int balance;

    Account(String accountNumber, String accountName, int balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    void showAccount() {
        System.out.println("Account: " + accountNumber + ", Name: " + accountName + ", Balance: " + balance);
    }
}

// Handles transactions (deposit, withdraw, transfer)
class Transaction {
    // Deposit money
    static synchronized void deposit(Account acc, int amount) {
        acc.balance += amount;
        System.out.println(acc.accountName + " deposited " + amount);
        acc.showAccount();
    }

    // Withdraw money
    static synchronized void withdraw(Account acc, int amount) {
        if (acc.balance >= amount) {
            acc.balance -= amount;
            System.out.println(acc.accountName + " withdrew " + amount);
        } else {
            System.out.println(acc.accountName + " - Not enough balance to withdraw " + amount);
        }
        acc.showAccount();
    }

    // Transfer money between accounts
    static synchronized void transfer(Account from, Account to, int amount) {
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

// Main management class
class Bank {
    ArrayList<Account> accounts = new ArrayList<>();

    // Add a new account
    void addAccount(Account acc) {
        accounts.add(acc);
    }

    // Find account by number
    Account findAccount(String accNum) {
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accNum)) return acc;
        }
        return null;
    }
}

public class FastBankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        // Add demo accounts
        bank.addAccount(new Account("1001", "Alice", 500));
        bank.addAccount(new Account("1002", "Bob", 300));

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Transfer\n4. Show All Accounts\n5. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Account number: ");
                String acc = sc.next();
                System.out.print("Amount: ");
                int amt = sc.nextInt();
                Account a = bank.findAccount(acc);
                if (a != null) Transaction.deposit(a, amt);
                else System.out.println("Account not found!");
            } else if (choice == 2) {
                System.out.print("Account number: ");
                String acc = sc.next();
                System.out.print("Amount: ");
                int amt = sc.nextInt();
                Account a = bank.findAccount(acc);
                if (a != null) Transaction.withdraw(a, amt);
                else System.out.println("Account not found!");
            } else if (choice == 3) {
                System.out.print("From Account: ");
                String from = sc.next();
                System.out.print("To Account: ");
                String to = sc.next();
                System.out.print("Amount: ");
                int amt = sc.nextInt();
                Account aFrom = bank.findAccount(from);
                Account aTo = bank.findAccount(to);
                if (aFrom != null && aTo != null) Transaction.transfer(aFrom, aTo, amt);
                else System.out.println("One or both accounts not found!");
            } else if (choice == 4) {
                for (Account a : bank.accounts) a.showAccount();
            } else if (choice == 5) {
                System.out.println("Thank you for using Fast Transactions App!");
                break;
            }
        }
        sc.close();
    }
}
