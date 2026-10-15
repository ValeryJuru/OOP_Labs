package Lab11;

// EXPLAIN: abstract: you can't create a plain LibraryItem, only a Book or a Dvd
public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;
    private Member borrower;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank() || id.contains(",")) {
            throw new IllegalArgumentException("Id is required and cannot contain a comma");
        }
        if (title == null || title.isBlank() || title.contains(",")) {
            throw new IllegalArgumentException("Title is required and cannot contain a comma");
        }
        this.id = id.trim();
        this.title = title.trim();
    }

    // EXPLAIN: each subclass decides its own loan period (polymorphism)
    public abstract int loanPeriodDays();

    // EXPLAIN: each subclass writes its own CSV line
    public abstract String toCsv();

    @Override
    public void borrow(Member member) throws ItemNotAvailableException {
        if (!available) {
            throw new ItemNotAvailableException(title + " is already on loan");
        }
        available = false;
        borrower = member;
    }

    @Override
    public void giveBack() {
        available = true;
        borrower = null;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }

    protected String status() {
        return available ? "available" : "on loan to " + borrower.getName();
    }
}