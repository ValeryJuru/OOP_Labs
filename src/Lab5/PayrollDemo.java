package Lab5;
//Intermediate

public class PayrollDemo {
    public static void main(String[] args) {
        // EXPLAIN: the only change for the new Intern class is one extra item in this array
        Employee[] staff = {
                new Employee("Kudzai", 2000),
                new Manager("Nyasha", 3500, 800),
                new Developer("Tatenda", 3000, 10),
                new Intern("Chiedza", 800)
        };

        double total = 0;
        for (Employee e : staff) {   // EXPLAIN: this loop never changes when a new subclass is added
            e.describe();
            total += e.calculatePay();
        }
        System.out.printf("Total payroll = %.2f%n", total);
    }
}
