package Lab11;

public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        if (author == null || author.isBlank() || author.contains(",")) {
            throw new IllegalArgumentException("Author is required and cannot contain a comma");
        }
        this.author = author.trim();
    }

    @Override
    public int loanPeriodDays() { return 14; }

    @Override
    public String toCsv() { return "BOOK," + getId() + "," + getTitle() + "," + author; }

    @Override
    public String toString() {
        return "Book[" + getId() + "] " + getTitle() + " by " + author + " - " + status();
    }
}