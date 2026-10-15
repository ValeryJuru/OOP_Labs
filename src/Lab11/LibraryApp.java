package Lab11;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Library library = loadLibrary();

        try (Scanner in = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\n1 Add item | 2 Register member | 3 Borrow | 4 Return"
                        + " | 5 Overdue | 6 Search | 0 Save and exit");
                System.out.print("> ");
                String choice = in.nextLine().trim();
                try {
                    switch (choice) {
                        case "1" -> {
                            String type = ask(in, "Type (book/dvd): ");
                            String id = ask(in, "Id: ");
                            String title = ask(in, "Title: ");
                            String extra = ask(in, "Author (book) or minutes (dvd): ");
                            library.addItem(ItemFactory.create(type, id, title, extra));
                            System.out.println("Item added");
                        }
                        case "2" -> {
                            library.registerMember(new Member(ask(in, "Member id: "), ask(in, "Name: ")));
                            System.out.println("Member registered");
                        }
                        case "3" -> {
                            Loan loan = library.borrow(ask(in, "Member id: "), ask(in, "Item id: "));
                            System.out.println("Borrowed. Due " + loan.getDueDate());
                        }
                        case "4" -> {
                            library.giveBack(ask(in, "Item id: "));
                            System.out.println("Returned");
                        }
                        case "5" -> {
                            List<Loan> overdue = library.listOverdue();
                            if (overdue.isEmpty()) System.out.println("No overdue items");
                            for (Loan l : overdue) System.out.println(l);
                        }
                        case "6" -> {
                            List<LibraryItem> found = library.searchByTitle(ask(in, "Title contains: "));
                            if (found.isEmpty()) System.out.println("No matches");
                            for (LibraryItem i : found) System.out.println(i);
                        }
                        case "0" -> running = false;
                        default -> System.out.println("Unknown option");
                    }
                } catch (ItemNotAvailableException | MemberLimitExceededException
                         | IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        try {
            LibraryStorage.save(library);
            System.out.println("Data saved");
        } catch (IOException e) {
            System.out.println("Could not save: " + e.getMessage());
        }
    }

    private static Library loadLibrary() {
        try {
            return LibraryStorage.load();
        } catch (IOException e) {
            System.out.println("Could not load saved data: " + e.getMessage());
            return new Library();
        }
    }

    private static String ask(Scanner in, String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }
}