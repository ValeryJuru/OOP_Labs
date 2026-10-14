package Lab8;
//Basic

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // EXPLAIN: wrapped in new ArrayList because List.of(...) is immutable
        List<String> names = new ArrayList<>(List.of(
                "Val", "Ashy", "Val", "Rudaviro", "Ashy", "Tino", "Rudaviro"));
        System.out.println("Original: " + names);

        // EXPLAIN: a Set rejects duplicates; LinkedHashSet also keeps insertion order
        Set<String> unique = new LinkedHashSet<>(names);
        System.out.println("Without duplicates: " + unique);
        System.out.println("Count: " + names.size() + " -> " + unique.size());
    }
}