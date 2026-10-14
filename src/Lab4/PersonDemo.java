package Lab4;
//Basic

public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("Valery", 22);
        Student s = new Student("Rudaviro", 20, "Computer Science");

        p.display();
        s.display();   // EXPLAIN: Student never wrote display(); it is inherited from Person
        System.out.println("Course: " + s.getCourse());
    }
}