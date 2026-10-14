package Lab1;
//Challenge

public class Person {
    String name;
    Address address;   // EXPLAIN: a field can itself be a reference to another object

    public static void main(String[] args) {
        Address a = new Address();
        a.street = "12 Samora Machel Ave";
        a.city = "Harare";

        Person p1 = new Person();
        p1.name = "Valery";
        p1.address = a;

        // EXPLAIN: chained dot: person -> address -> city
        System.out.println(p1.name + " lives in " + p1.address.city);

        Person p2 = new Person();
        p2.name = "Ashley";
        // p2.address was never assigned, so it is null

        // EXPLAIN: p2.address is null, so reading .city from it throws NullPointerException
        try {
            System.out.println(p2.address.city);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + p2.name + " has no address");
        }

        // EXPLAIN: the safe way is to check for null before the chained dot
        if (p2.address == null) {
            System.out.println(p2.name + " has no address on record");
        } else {
            System.out.println(p2.name + " lives in " + p2.address.city);
        }
    }
}
