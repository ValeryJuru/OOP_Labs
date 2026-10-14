package Lab2;
//Basic

public class Circle {
    private static int count = 0;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() {
        this(1.0);   // goes through the first constructor, so it is counted too
    }

    public static int getCount() {
        return count;
    }

    public void display() {
        System.out.println("Circle with radius " + radius);
    }

    public static void main(String[] args) {
        new Circle(7.5).display();
        new Circle().display();
        System.out.println("Circles created: " + Circle.getCount());
    }
}
