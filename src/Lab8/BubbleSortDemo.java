package Lab8;
// Challenge

import java.util.Arrays;

public class BubbleSortDemo {

    // EXPLAIN: bounded type: T must be Comparable<T>, so compareTo is available
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1, 7};
        String[] words = {"pear", "apple", "zebra", "mango"};

        bubbleSort(nums);
        bubbleSort(words);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));

        int[] prim = {3, 1, 2};
        // bubbleSort(prim);   // COMPILE ERROR: int[] cannot be used as T[]

        /*Why int[] will not work
        *Generics work only with reference types. After type checking, the compiler erases T, so it can never stand for a primitive such as int.
        * int has no compareTo method. The wrapper Integer is an object that implements Comparable<Integer>, which is what the bound T extends Comparable<T> demands.
        * Autoboxing converts one int to one Integer, but not a whole array. int[] and Integer[] are different types, so an int[] can’t be passed where a T[] is expected. The fix is to use Integer[].
        * */
    }
}