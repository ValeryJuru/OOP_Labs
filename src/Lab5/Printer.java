package Lab5;
//Basic

public class Printer {

    // EXPLAIN: same name, different parameter lists -> the compiler picks one from the argument type
    void print(int n)       { System.out.println("int: " + n); }
    void print(double d)    { System.out.println("double: " + d); }
    void print(String s)    { System.out.println("String: " + s); }

    void print(int[] arr) {
        String out = "int[]:";
        for (int n : arr) {
            out += " " + n;
        }
        System.out.println(out);
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        p.print(7);
        p.print(3.14);
        p.print("Hello");
        p.print(new int[]{1, 2, 3});
    }
}
