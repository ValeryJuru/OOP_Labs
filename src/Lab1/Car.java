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
    public static void main(String[] args) {
        // EXPLAIN: three separate objects, each with its own values
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.year = 2018;
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
    }
}
