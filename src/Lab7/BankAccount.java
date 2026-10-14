package Lab7;
//Intermediate

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private String[] history = new String[100];
    private int historyCount = 0;

    public BankAccount(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        if (openingBalance > 0) {
            balance = openingBalance;
        }
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        record("Deposit " + amount);
        return true;
    }

    // EXPLAIN: returns nothing now; failure is reported by throwing
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + "; balance is " + balance, amount - balance);
        }
        balance -= amount;
    }

    private void record(String entry) {
        if (historyCount < history.length) {
            history[historyCount] = entry;
            historyCount++;
        }
    }

    public double getBalance() {
        return balance;
    }

    // returns a COPY, so the caller cannot change the real history
    public String[] getHistory() {
        String[] copy = new String[historyCount];
        for (int i = 0; i < historyCount; i++) {
            copy[i] = history[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", 500.0);
        acc.deposit(300.0);

        try {
            acc.withdraw(100.0);
            acc.withdraw(5000.0);              // fails
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }

        String[] h = acc.getHistory();
        h[0] = "HACKED";                       // only changes the copy

        for (String line : acc.getHistory()) {
            System.out.println(line);
        }
        System.out.println("Balance: " + acc.getBalance());
    }
}