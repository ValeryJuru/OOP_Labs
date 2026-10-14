package Lab7;
//Basic

import java.util.Scanner;

public class DivideInput {
    public static void main(String[] args) {
        // EXPLAIN: try-with-resources closes the Scanner automatically
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter first integer: ");
            int a = Integer.parseInt(in.nextLine());
            System.out.print("Enter second integer: ");
            int b = Integer.parseInt(in.nextLine());
            System.out.println(a + " / " + b + " = " + (a / b));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: please enter whole numbers only");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }
}
