package Lab5;
//Basic

class Animal {
    String sound() { return "..."; }
}

class Cat extends Animal {
    @Override String sound() { return "Meow"; }   // EXPLAIN: @Override makes the compiler check the signature
}

class Cow extends Animal {
    @Override String sound() { return "Moo"; }
}

class Duck extends Animal {
    @Override String sound() { return "Quack"; }
}

public class AnimalSounds {
    public static void main(String[] args) {
        // EXPLAIN: upcasting -> one Animal[] holds Cat, Cow and Duck objects
        Animal[] animals = { new Cat(), new Cow(), new Duck() };

        for (Animal a : animals) {
            // EXPLAIN: the JVM picks sound() from the ACTUAL object at run time
            System.out.println(a.sound());
        }
    }
}
