package Lab6;
// Basic

interface Flyable {
    void fly();   // EXPLAIN: implicitly public abstract
}

// EXPLAIN: Bird and Aeroplane share NO superclass, only the capability
class Bird implements Flyable {
    @Override
    public void fly() {   // EXPLAIN: interface methods must be public
        System.out.println("Bird flaps its wings and flies");
    }
}

class Aeroplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Aeroplane takes off and flies");
    }
}

public class FlyableDemo {
    public static void main(String[] args) {
        // EXPLAIN: program to the interface: the variable type is Flyable
        Flyable[] things = { new Bird(), new Aeroplane() };

        for (Flyable f : things) {
            f.fly();
        }
    }
}
