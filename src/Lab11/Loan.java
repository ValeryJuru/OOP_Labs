package Lab11;

import java.time.LocalDate;

public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate borrowedOn;
    private final LocalDate dueDate;

    public Loan(LibraryItem item, Member member, LocalDate borrowedOn, LocalDate dueDate) {
        if (item == null || member == null || borrowedOn == null || dueDate == null) {
            throw new IllegalArgumentException("Loan details cannot be null");
        }
        if (dueDate.isBefore(borrowedOn)) {
            throw new IllegalArgumentException("Due date cannot be before the borrow date");
        }
        this.item = item;
        this.member = member;
        this.borrowedOn = borrowedOn;
        this.dueDate = dueDate;
    }

    public LibraryItem getItem() { return item; }
    public Member getMember() { return member; }
    public LocalDate getBorrowedOn() { return borrowedOn; }
    public LocalDate getDueDate() { return dueDate; }

    public boolean isOverdue() { return LocalDate.now().isAfter(dueDate); }

    @Override
    public String toString() {
        return item.getTitle() + " -> " + member.getName() + ", due " + dueDate;
    }
}