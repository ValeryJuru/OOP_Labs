package Lab9;
// Basic

// EXPLAIN: one line gives constructor, accessors, equals, hashCode and toString
record Student(String name, int age) { }

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tammy", 20);
        Student s2 = new Student("Tammy", 20);
        Student s3 = new Student("Freddy", 21);

        System.out.println(s1);                                    // generated toString
        System.out.println("s1 == s2: " + (s1 == s2));             // different objects
        System.out.println("s1.equals(s2): " + s1.equals(s2));     // same values
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("Name: " + s1.name() + ", age: " + s1.age());   // accessors
    }
}