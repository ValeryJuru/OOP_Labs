package Lab1;
//Exercise 1.1

public class Car {

    //EXPLAIN: fields = the STATE of every Car object
    String brand;
    int year;
    int mileage;

    //EXPLAIN: method = BEHAVIOR, it prits the object's own fields
    void display(){
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage + " km");
    }
    // EXPLAIN: returns true when this car's age is more than 25 years
    boolean isAntique() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year > 25;
    }
    public static void main(String[] args) {
        // EXPLAIN: three separate objects, each with its own values
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.year = 1990;
        c1.mileage = 85000;

        Car c2 = new Car();
        c2.brand = "Mercedes";
        c2.year = 2005;
        c2.mileage = 210000;

        Car c3 = new Car();
        c3.brand = "Rolls Royce";
        c3.year = 2021;
        c3.mileage = 30000;

        c1.display();
        c2.display();
        c3.display();

        System.out.println(c1.brand + " antique? " + c1.isAntique());
        System.out.println(c2.brand + " antique? " + c2.isAntique());
        System.out.println(c3.brand + " antique? " + c3.isAntique());
    }
}
