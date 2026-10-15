package Lab11;

// EXPLAIN: extends Exception, so it is CHECKED: callers must handle or declare it
public class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String message) {
        super(message);
    }
}