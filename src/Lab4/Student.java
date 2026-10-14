package Lab4;
//Basic

public class Student extends Person {   // EXPLAIN: Student IS-A Person

    private String course;

    public Student(String name, int age, String course) {
        super(name, age);   // EXPLAIN: must be first; runs Person's constructor
        this.course = course;
    }

    public String getCourse() { return course; }
}
