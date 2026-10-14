package Lab5;
// Challenge

class Payment {
    private final double amount;
    Payment(double amount) { this.amount = amount; }
    double getAmount() { return amount; }

    void process() {                              // default behaviour
        System.out.println("Generic payment of " + amount);
    }
}

class CardPayment extends Payment {
    private final String holder;
    CardPayment(double amount, String holder) { super(amount); this.holder = holder; }

    @Override void process() {
        System.out.println("Card payment of " + getAmount() + " for " + holder);
    }
}

class MobileMoneyPayment extends Payment {
    private final String phone;
    MobileMoneyPayment(double amount, String phone) { super(amount); this.phone = phone; }

    @Override void process() {
        System.out.println("Mobile money payment of " + getAmount() + " from " + phone);
    }
}

class PaymentProcessor {
    void pay(Payment p) {
        p.process();   // EXPLAIN: no instanceof needed, each object knows how to process itself
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

/*
Comparing the two designs
- Design A: every time you add a new payment type, such as bank transfer, you must go back and edit pay(). If you forget, the new type silently falls into "Unknown payment type".
- Design B: you add a new class that overrides process(), and PaymentProcessor never changes. This is the "open for extension, closed for modification" idea from the objectives.
- When A is still fine: if you cannot edit the payment classes (they belong to someone else), instanceof is the only option.
*/