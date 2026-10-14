package Lab7;
// Basic

public class ArrayAccess {

    static void show(int[] data, int index) {
        try {
            System.out.println("data[" + index + "] = " + data[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index " + index + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30};
        show(data, 1);
        show(data, 5);
        show(data, -1);
    }
}
