package Lab11;

public class Dvd extends LibraryItem {
    private final int minutes;

    public Dvd(String id, String title, int minutes) {
        super(id, title);
        if (minutes <= 0) {
            throw new IllegalArgumentException("Minutes must be positive");
        }
        this.minutes = minutes;
    }

    @Override
    public int loanPeriodDays() { return 7; }

    @Override
    public String toCsv() { return "DVD," + getId() + "," + getTitle() + "," + minutes; }

    @Override
    public String toString() {
        return "DVD[" + getId() + "] " + getTitle() + " (" + minutes + " min) - " + status();
    }
}