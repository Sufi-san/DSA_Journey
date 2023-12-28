package _2_Implementation.OOP._4_Access_N_More.FirstPackage;

public class OtherClass {
    static String classVar = "Public OtherClass";
    public int var1 = 1;
    protected int var2 = 2;
    int var3 = 3;
    private int var4;
    void method() {
        System.out.println(OtherClass.classVar); // public class accessible inside itself
        // Actually, every class irrespective of its specifier, is accessible inside itself
    }
}

// protected and private access specifiers cannot be used with classes

class NoModifier {
    static String classVar = "No Modifier NoModifier";
    void method() {
        System.out.println(NoModifier.classVar); // clas with no modifier accessible inside itself
        // Actually, every class irrespective of its specifier, is accessible inside itself

    }
}
