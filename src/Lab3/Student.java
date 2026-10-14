package Lab3;
//Basic

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        setMarks(marks);   // reuse the validation; marks stays 0 if invalid
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }

    public boolean setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            return false;   // rejected, nothing changes
        }
        this.marks = marks;
        return true;
    }

    public static void main(String[] args) {
        Student s = new Student("Valery", 85);
        System.out.println(s.getName() + " " + s.getMarks());
        System.out.println("Set 150: " + s.setMarks(150));
        System.out.println("Marks still: " + s.getMarks());
    }
}
