package Lab7;
//Intermediate

// EXPLAIN: extending Exception makes this a CHECKED exception
public class InvalidAgeException extends Exception {

    private final int age;

    public InvalidAgeException(String message, int age) {
        super(message);
        this.age = age;
    }

    public int getAge() { return age; }
}
