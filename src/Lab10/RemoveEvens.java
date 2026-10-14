package Lab10;
//Basic

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveEvens {
    public static void main(String[] args) {
        // EXPLAIN: wrapped in new ArrayList because List.of(...) is immutable
        List<Integer> nums = new ArrayList<>(List.of(3, 8, 15, 22, 7, 10, 9, 4));
        System.out.println("Before: " + nums);

        // EXPLAIN: a Predicate is a lambda that answers true/false for one element
        Predicate<Integer> isEven = n -> n % 2 == 0;
        nums.removeIf(isEven);

        System.out.println("After: " + nums);
    }
}