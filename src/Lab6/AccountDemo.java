package Lab6;
//Intermediate

abstract class Account {
    private double balance;

    Account(double openingBalance) {
        if (openingBalance > 0) {
            balance = openingBalance;
        }
    }

    // EXPLAIN: concrete method -> shared code, written once for all accounts
    boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    // EXPLAIN: abstract -> each account type decides its own fee
    abstract double monthlyFee();

    void applyMonthlyFee() {
        balance -= monthlyFee();   // EXPLAIN: shared code calls the subclass's version
    }

    double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    SavingsAccount(double openingBalance) { super(openingBalance); }
    @Override double monthlyFee() { return 2.50; }
}

class CurrentAccount extends Account {
    CurrentAccount(double openingBalance) { super(openingBalance); }
    @Override double monthlyFee() { return 10.00; }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account savings = new SavingsAccount(500);
        Account current = new CurrentAccount(500);

        savings.deposit(100);
        savings.applyMonthlyFee();
        current.deposit(100);
        current.applyMonthlyFee();

        System.out.printf("Savings balance: %.2f%n", savings.getBalance());
        System.out.printf("Current balance: %.2f%n", current.getBalance());
    }
}