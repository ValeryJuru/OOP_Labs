package Lab10;
//Intermediate

import java.util.List;

record Student(String name, int mark) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Tammy", 72),
                new Student("Freddy", 55),
                new Student("Ruth", 88),
                new Student("Kuda", 64),
                new Student("Ada", 91),
                new Student("Lynn", 49));

        // EXPLAIN: mapToInt turns each Student into its mark; average() gives an OptionalDouble
        double average = students.stream()
                .mapToInt(Student::mark)
                .average()
                .orElse(0);
        System.out.printf("Class average: %.1f%n", average);

        // EXPLAIN: source -> filter -> map -> sorted -> forEach (terminal operation)
        System.out.println("Above average:");
        students.stream()
                .filter(s -> s.mark() > average)
                .map(Student::name)
                .sorted()
                .forEach(System.out::println);
    }
}