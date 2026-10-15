package Lab11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// EXPLAIN: single responsibility: this class only reads and writes files
public class LibraryStorage {
    private static final Path ITEMS = Path.of("items.csv");
    private static final Path MEMBERS = Path.of("members.csv");
    private static final Path LOANS = Path.of("loans.csv");

    public static void save(Library library) throws IOException {
        List<String> lines = new ArrayList<>();
        for (LibraryItem i : library.getItems()) lines.add(i.toCsv());
        Files.write(ITEMS, lines);

        lines = new ArrayList<>();
        for (Member m : library.getMembers()) lines.add(m.getId() + "," + m.getName());
        Files.write(MEMBERS, lines);

        lines = new ArrayList<>();
        for (Loan l : library.getLoans()) {
            lines.add(l.getMember().getId() + "," + l.getItem().getId() + ","
                    + l.getBorrowedOn() + "," + l.getDueDate());
        }
        Files.write(LOANS, lines);
    }

    public static Library load() throws IOException {
        Library library = new Library();
        try {
            if (Files.exists(ITEMS)) {
                for (String line : Files.readAllLines(ITEMS)) {
                    if (line.isBlank()) continue;
                    String[] p = line.split(",");
                    library.addItem(ItemFactory.create(p[0], p[1], p[2], p[3]));
                }
            }
            if (Files.exists(MEMBERS)) {
                for (String line : Files.readAllLines(MEMBERS)) {
                    if (line.isBlank()) continue;
                    String[] p = line.split(",");
                    library.registerMember(new Member(p[0], p[1]));
                }
            }
            if (Files.exists(LOANS)) {
                for (String line : Files.readAllLines(LOANS)) {
                    if (line.isBlank()) continue;
                    String[] p = line.split(",");
                    library.restoreLoan(p[0], p[1], LocalDate.parse(p[2]), LocalDate.parse(p[3]));
                }
            }
        } catch (ItemNotAvailableException | MemberLimitExceededException | RuntimeException e) {
            // EXPLAIN: any bad line in the files is reported as one clear I/O problem (exception chaining)
            throw new IOException("Saved data is invalid: " + e.getMessage(), e);
        }
        return library;
    }
}