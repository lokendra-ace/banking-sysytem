
import java.util.*;

// Customer class
class Customer {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Transaction class
class Transaction {
    private final String type;
    private final double amount;
    private final java.time.LocalDateTime dateTime;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = java.time.LocalDateTime.now();
    }

    @Override
    public String toString() {
        return dateTime + " | " + type + " | Amount: " + amount;
    }
}

// Account class
class Account {
    private final int accountNumber;
    private final Customer customer;
    private double balance;
    private final List<Transaction> transactions;

    public Account(int accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void printDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Current Balance: " + balance);
        System.out.println("Transaction History:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}

// Bank class
class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();
    private int accountCounter = 1001;

    public void createAccount(Scanner sc) {
        System.out.print("Enter customer name: ");
        sc.nextLine(); // consume newline
        String name = sc.nextLine();
        Customer customer = new Customer(name);
        Account account = new Account(accountCounter++, customer);
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created successfully! Account Number: " + account.getAccountNumber());
    }

    public void deposit(Scanner sc) {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(Scanner sc) {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void showAccountDetails(Scanner sc) {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.printDetails();
        } else {
            System.out.println("Account not found.");
        }
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> bank.createAccount(sc);
                case 2 -> bank.deposit(sc);
                case 3 -> bank.withdraw(sc);
                case 4 -> bank.showAccountDetails(sc);
                case 5 -> {
                    System.out.println("Exiting. Thank you!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
