package Lab2;
//Intermediate

public class BlockTest {
    static { System.out.println("static block 1"); }
    { System.out.println("instance block 1"); }
    static { System.out.println("static block 2"); }
    { System.out.println("instance block 2"); }

    BlockTest() { System.out.println("constructor"); }

    public static void main(String[] args) {
        System.out.println("--- main starts ---");
        new BlockTest();
        System.out.println("--- second object ---");
        new BlockTest();
    }
}
