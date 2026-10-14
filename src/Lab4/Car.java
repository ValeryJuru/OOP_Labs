package Lab4;
// Intermediate

public class Car extends Vehicle {
    public Car() {
        // EXPLAIN: Java inserts super() here automatically -> Vehicle() runs first
        System.out.println("Car constructor");
    }
}
