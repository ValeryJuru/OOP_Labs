package Lab4;
// Intermediate

public class ElectricCar extends Car {   // EXPLAIN: multilevel inheritance, Vehicle -> Car -> ElectricCar
    public ElectricCar() {
        // EXPLAIN: implicit super() -> Car() runs first, which runs Vehicle() first
        System.out.println("ElectricCar constructor");
    }
}
