package Lab11;

import java.util.ArrayList;
import java.util.List;

public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank() || id.contains(",")) {
            throw new IllegalArgumentException("Member id is required and cannot contain a comma");
        }
        if (name == null || name.isBlank() || name.contains(",")) {
            throw new IllegalArgumentException("Name is required and cannot contain a comma");
        }
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getLoanCount() { return loans.size(); }

    void addLoan(Loan loan) { loans.add(loan); }
    void removeLoan(Loan loan) { loans.remove(loan); }

    @Override
    public String toString() {
        return "Member[" + id + "] " + name + " (" + loans.size() + " loans)";
    }
}