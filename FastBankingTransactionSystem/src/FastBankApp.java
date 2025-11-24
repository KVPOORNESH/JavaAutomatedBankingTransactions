import java.util.Scanner;

public class FastBankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

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
                System.out.println("Thank you for using FastBankingTransactionSystem!");
                break;
            }
        }
        sc.close();
    }
}

