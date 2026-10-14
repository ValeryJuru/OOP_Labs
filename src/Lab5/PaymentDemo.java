package Lab5;
// Challenge

class Payment {
    private final double amount;
    Payment(double amount) { this.amount = amount; }
    double getAmount() { return amount; }
}

class CardPayment extends Payment {
    private final String holder;
    CardPayment(double amount, String holder) { super(amount); this.holder = holder; }
    String getHolder() { return holder; }
}

class MobileMoneyPayment extends Payment {
    private final String phone;
    MobileMoneyPayment(double amount, String phone) { super(amount); this.phone = phone; }
    String getPhone() { return phone; }
}

class PaymentProcessor {
    void pay(Payment p) {
        // EXPLAIN: pattern matching -> tests the type AND casts in one step
        if (p instanceof CardPayment c) {
            System.out.println("Card payment of " + p.getAmount() + " for " + c.getHolder());
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.println("Mobile money payment of " + p.getAmount() + " from " + m.getPhone());
        } else {
            System.out.println("Unknown payment type");
        }
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor proc = new PaymentProcessor();
        proc.pay(new CardPayment(50.0, "Valery"));
        proc.pay(new MobileMoneyPayment(20.0, "0772345675"));
        proc.pay(new Payment(5.0));
    }
}