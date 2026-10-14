package Lab2;
//Basic

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
        this(1.0);   // default radius
    }

    public void display() {
        System.out.println("Circle with radius " + radius);
    }

    public static void main(String[] args) {
        new Circle(7.5).display();
        new Circle().display();
    }
}
