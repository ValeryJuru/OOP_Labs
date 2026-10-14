package Lab9;
//Intermediate

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // EXPLAIN: two books are equal when their ISBN is equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);
    }

    // EXPLAIN: equal objects MUST give equal hash codes, so use the same field
    @Override
    public int hashCode() { return Objects.hash(isbn); }

    @Override
    public String toString() { return title + " [" + isbn + "]"; }
}

public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("ISBN-100", "Java Basics");
        Book b2 = new Book("ISBN-100", "Java Basics (second copy)");
        Book b3 = new Book("ISBN-200", "Data Structures");

        System.out.println("b1 == b2: " + (b1 == b2));
        System.out.println("b1.equals(b2): " + b1.equals(b2));
        System.out.println("Same hash? " + (b1.hashCode() == b2.hashCode()));

        // EXPLAIN: add() returns false when the set already holds an equal element
        Set<Book> set = new HashSet<>();
        System.out.println("add b1: " + set.add(b1));
        System.out.println("add b2: " + set.add(b2));
        System.out.println("add b3: " + set.add(b3));
        System.out.println("Set size: " + set.size());
    }
}