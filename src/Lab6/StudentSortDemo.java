package Lab6;
// Intermediate

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) { this.name = name; this.marks = marks; }

    String getName() { return name; }
    int getMarks() { return marks; }

    // EXPLAIN: the class's NATURAL order -> alphabetical by name
    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() { return name + "(" + marks + ")"; }
}

// EXPLAIN: a separate ordering object -> lowest marks first
class MarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(a.getMarks(), b.getMarks());
    }
}

public class StudentSortDemo {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Valery", 70), new Student("Stacey", 85), new Student("Ash", 60)
        };

        Arrays.sort(students);                        // uses compareTo (by name)
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new MarksComparator()); // uses the Comparator (by marks)
        System.out.println(Arrays.toString(students));
    }
}
