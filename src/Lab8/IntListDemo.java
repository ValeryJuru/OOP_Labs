package Lab8;
//Basic

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntListDemo {
    public static void main(String[] args) {
        // EXPLAIN: program to the interface (List), create an ArrayList
        List<Integer> nums = new ArrayList<>();
        int[] values = {12, 7, 25, 3, 18, 9, 31, 14, 6, 20};
        for (int v : values) {
            nums.add(v);                    // autoboxing: int -> Integer
        }
        System.out.println("List: " + nums);

        int sum = 0;
        for (int n : nums) {
            sum += n;                       // unboxing: Integer -> int
        }
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + Collections.max(nums));

        Collections.reverse(nums);
        System.out.println("Reversed: " + nums);
    }
}