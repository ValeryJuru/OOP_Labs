package Lab4;
// Intermediate

public class Animal {
    private String name;

    // EXPLAIN: writing ANY constructor removes the hidden default one (Lab 2),
    // so Animal now has NO no-argument constructor
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor: " + name);
    }

    public String getName() { return name; }
}
