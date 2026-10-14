package Lab4;
//Basic

public class Teacher extends Person {   // EXPLAIN: Teacher IS-A Person

    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() { return subject; }
}
