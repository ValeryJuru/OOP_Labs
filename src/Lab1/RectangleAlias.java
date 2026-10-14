package Lab1;

public class RectangleAlias {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 4;
        r1.height = 5;

        // EXPLAIN: r2 copies the REFERENCE, so r1 and r2 point to the SAME object
        Rectangle r2 = r1;
        r2.width = 10;

        System.out.println("r1.width = " + r1.width);
        System.out.println("r2.width = " + r2.width);
        System.out.println("Same object? " + (r1 == r2));
    }
    // Prediction: r1.width prints 10.0, not 4.0. There is only one rectangle object, and r1 and r2 are two names for it, so a change made through r2 is visible through r1.

    // Explanation: Rectangle r2 = r1; does not create a new rectangle. It copies the reference, so both variables point to the same object on the heap. Changing r2.width therefore changes the object that r1 also points to, and r1.width prints 10.0. r1 == r2 is true because == compares references.
}

