package Lab2;
//Intermediate

public class Employee {
    private static int counter = 0;
    private final int employeeId;
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        counter++;
        this.employeeId = counter;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, double salary) {
        this(name, salary, "General");
    }

    public Employee(String name) {
        this(name, 0.0);
    }

    // copy constructor: same details, but a new employee gets a new id
    public Employee(Employee other) {
        this(other.name, other.salary, other.department);
    }

    public void display() {
        System.out.printf("#%d %s, %s, $%.2f%n", employeeId, name, department, salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Valery", 1500.0, "IT");
        Employee e2 = new Employee("Ruvimbo", 1200.0);
        Employee e3 = new Employee("Ash");
        Employee e4 = new Employee(e1);
        e1.display();
        e2.display();
        e3.display();
        e4.display();
    }
}
