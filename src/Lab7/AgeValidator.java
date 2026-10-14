package Lab7;
//Intermediate

public class AgeValidator {

    // EXPLAIN: 'throws' warns callers they must handle this checked exception
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            // EXPLAIN: 'throw' creates and throws the exception object
            throw new InvalidAgeException("Age must be between 0 and 120, got " + age, age);
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] tests = {25, 0, 120, -5, 130};
        for (int age : tests) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Rejected: " + e.getMessage());
            }
        }
    }
}