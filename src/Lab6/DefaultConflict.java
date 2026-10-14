package Lab6;
//Challenge

interface Swimmer {
    default void hello() { System.out.println("Hello from Swimmer"); }
}

interface Walker {
    default void hello() { System.out.println("Hello from Walker"); }
}

// EXPLAIN: both interfaces give hello(), so the compiler cannot choose -> the class MUST override it
class Duck implements Swimmer, Walker {
    @Override
    public void hello() {
        Swimmer.super.hello();   // EXPLAIN: InterfaceName.super picks one parent's version
        Walker.super.hello();
    }
}

public class DefaultConflict {
    public static void main(String[] args) {
        new Duck().hello();
    }
}
