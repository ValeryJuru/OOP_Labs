package Lab4;
//Intermediate

// BROKEN VERSION (kept as a comment so the project still compiles):
//
// public class Dog extends Animal {
//     public Dog(String name) {
//         System.out.println("Dog constructor");
//     }
// }
//
// Compile error: constructor Animal in class Animal cannot be applied to given types
// Reason: Dog's constructor has no super(...) call, so Java inserts super() for us.
// super() looks for Animal(), but Animal only has Animal(String name).

// FIXED VERSION:
public class Dog extends Animal {

    public Dog(String name) {
        super(name);   // EXPLAIN: we pass the name up, so the matching Animal(String) constructor runs
        System.out.println("Dog constructor: " + name);
    }

    public static void main(String[] args) {
        new Dog("Donner");
    }
}
