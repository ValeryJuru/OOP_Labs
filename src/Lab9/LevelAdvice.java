package Lab9;
//Basic

enum Level { LOW, MEDIUM, HIGH }

public class LevelAdvice {

    // EXPLAIN: switch on an enum; each case is one constant
    static void advice(Level level) {
        switch (level) {
            case LOW -> System.out.println("LOW: Safe to continue as normal");
            case MEDIUM -> System.out.println("MEDIUM: Be careful and keep monitoring");
            case HIGH -> System.out.println("HIGH: Stop and act immediately");
        }
    }

    public static void main(String[] args) {
        // EXPLAIN: values() returns every constant in declaration order
        for (Level l : Level.values()) {
            advice(l);
        }
    }
}
