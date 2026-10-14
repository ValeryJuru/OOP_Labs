package Lab2;
// Challenge

public class Temperature {
    private double celsius;

    private Temperature(double celsius) {
        this.celsius = celsius;
    }

    public static Temperature fromCelsius(double c) {
        return new Temperature(c);
    }

    public static Temperature fromFahrenheit(double f) {
        return new Temperature((f - 32) * 5 / 9);
    }

    public void display() {
        System.out.printf("%.1f C = %.1f F%n", celsius, celsius * 9 / 5 + 32);
    }

    public static void main(String[] args) {
        Temperature.fromCelsius(100).display();
        Temperature.fromFahrenheit(32).display();
    }
    //Two constructors that both take one double cannot exist, because Java cannot tell them apart. Even if they could, new Temperature(100) does not say whether 100 is Celsius or Fahrenheit. A factory has a name, so Temperature.fromFahrenheit(32) explains itself when you read it.
}
