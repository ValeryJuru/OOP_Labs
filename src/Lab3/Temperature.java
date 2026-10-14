package Lab3;
//Challenge

public class Temperature {

    // EXPLAIN: kelvin is the internal unit, hidden from callers
    private double kelvin;

    public Temperature(double kelvin) {
        setKelvin(kelvin);   // EXPLAIN: constructor reuses the validation in the setter
    }

    // Setter with validation
    public boolean setKelvin(double kelvin) {
        if (kelvin < 0) {
            return false;   // EXPLAIN: below absolute zero is impossible, so reject it
        }
        this.kelvin = kelvin;
        return true;
    }

    // EXPLAIN: callers use these getters only, so the internal unit can change without breaking them
    public double getCelsius() { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9 / 5 + 32; }

    public static void main(String[] args) {
        Temperature t = new Temperature(300);
        System.out.printf("%.2f C, %.2f F%n", t.getCelsius(), t.getFahrenheit());
        System.out.println("Set -5 K: " + t.setKelvin(-5));
    }
}