package Lab11;

// EXPLAIN: Factory pattern: callers pass a type word and never name Book or Dvd
public class ItemFactory {
    public static LibraryItem create(String type, String id, String title, String extra) {
        return switch (type.trim().toUpperCase()) {
            case "BOOK" -> new Book(id, title, extra);
            case "DVD" -> new Dvd(id, title, Integer.parseInt(extra.trim()));
            default -> throw new IllegalArgumentException("Unknown item type: " + type);
        };
    }
}