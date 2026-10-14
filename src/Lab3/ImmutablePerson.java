package Lab3;
// Intermediate

public final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public static void main(String[] args) {
        ImmutablePerson p = new ImmutablePerson("Stacey", 21);
        System.out.println(p.getName() + " is " + p.getAge());
    }
    /* Design choices
    - final class: nobody can create a child class that adds ways to change the person.
    - private fields: outside code cannot touch them directly.
    -final fields: each one is given a value once, in the constructor, and never changes after that.
    - Getters are safe: String and int cannot be changed by the caller, so returning them leaks nothing.
    */
}
