package Lab4;
//Basic

public class Person {

    // EXPLAIN: private -> only Person's own code touches these; subclasses use the getters
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    // EXPLAIN: written once here, and inherited by every subclass
    public void display() {
        System.out.println(name + ", age " + age);
    }
}
