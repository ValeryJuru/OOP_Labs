package Lab5;
//Intermediate

public class Intern extends Employee {

    private static final double ALLOWANCE = 100.0;   // my assumption: a fixed allowance on top of base pay

    public Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return baseSalary + ALLOWANCE;
    }
}
