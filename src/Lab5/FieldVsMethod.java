package Lab5;
//Intermediate

class Parent {
    String label = "Parent field";
    String who() { return "Parent method"; }
}

class Child extends Parent {
    String label = "Child field";                 // EXPLAIN: hides the field, does NOT override it
    @Override String who() { return "Child method"; }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child();   // upcast: declared type Parent, actual object Child

        System.out.println(p.who());     // method -> decided by the ACTUAL object
        System.out.println(p.label);     // field  -> decided by the DECLARED type

        if (p instanceof Child c) {
            System.out.println(c.label); // through a Child reference we see Child's field
        }
    }
}

//Why: methods can be overridden, so Java checks the real object when the program runs. Fields cannot be overridden. The compiler just looks at the variable's type (Parent), so it reads Parent's field.