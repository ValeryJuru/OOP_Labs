package Lab8;
//Intermediate

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter a paragraph:");
            String text = in.nextLine();

            // EXPLAIN: lower-case and strip punctuation so "The," and "the" count as one word
            String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");

            // EXPLAIN: TreeMap keeps words alphabetical, which orders words with equal counts
            Map<String, Integer> freq = new TreeMap<>();
            for (String w : words) {
                freq.merge(w, 1, Integer::sum);     // add 1, or start at 1
            }

            // EXPLAIN: a Map can't be sorted by value, so copy its entries into a List
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
            entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            for (Map.Entry<String, Integer> e : entries) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }
        }
    }
}
