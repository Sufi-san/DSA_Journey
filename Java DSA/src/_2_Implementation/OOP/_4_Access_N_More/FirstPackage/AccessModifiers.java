package _2_Implementation.OOP._4_Access_N_More.FirstPackage;

// cannot access 'NoModifierOtherPkg'  because it isn't public class
// import _2_Implementation.OOP._4_Access_N_More.SecondPackage.NoModifierOtherPkg;
import _2_Implementation.OOP._4_Access_N_More.SecondPackage.OtherPkgClass;

public class AccessModifiers { // This class itself is an example of 'public' class
    public int var1;
    protected int var2;
    int var3;
    private int var4;
    /*
        The 3 important access modifiers are:
        1) public - available everywhere
        2) private - available only in this class or file
        3) protected - not available in other packages which do not contain subclass

        Using these, there occur certain possible combinations and situations, all of which
        we will try to look at now:
        (Chart: (+) means accessible, 'empty' means non-accessible)
        Accessible inside | (Class, Package, Subclass (same pkg), Subclass (diff pkg), World (diff pkg & not subclass)
            public ->           +      +              +                    +                         +
            protected ->        +      +              +                    +
            no modifier ->      +      +              +
            private ->          +
        Total Outcomes: 20
        Accessible: 13
        Non-Accessible: 7
     */
    public static void main(String[] args) {
        AccessModifiers obj = new AccessModifiers();
        obj.checkMethod();
    }

    public void checkMethod() {
        OtherClass OC = new OtherClass(); // For classes, Public class accessible inside another class in same package
        NoModifier NM = new NoModifier(); // For classes, No Modifier class accessible inside another class in same package

        // All the same rules will apply to 'methods' the same as they apply to variables

        this.var1 = 1; // public variable accessible inside class itself, Outcome: 1, Accessible: 1
        this.var2 = 2; // protected variable accessible inside class itself, Outcome: 2, Accessible: 2
        this.var3 = 3; // no modifier variable accessible inside class itself, Outcome: 3, Accessible: 3
        this.var4 = 4; // private variable accessible inside class itself, Outcome: 4, Accessible: 4
        System.out.println(this.var1+", "+this.var2+", "+this.var3+", "+this.var4);

        OC.var1 = 1; // public variable accessible inside another class in same package, Outcome: 5, Accessible: 5
        OC.var2 = 2; // protected variable accessible inside another class in same package, Outcome: 6, Accessible: 6
        OC.var3 = 3; // no modifier variable accessible inside another class in same package, Outcome: 7, Accessible: 7
        // OC.var4 = 4; // private variable NOT accessible inside another class, Outcome 8, Non-Accessible: 1
        System.out.println(OC.var1+", "+OC.var2+", "+OC.var3);

        Subclass.subMethod();
        Subclass1.method();
        OtherClass1.method();

        // In Short:
        // public -> available everywhere
        // protected -> available everywhere in same package, available via inheritance in different package
        // no modifier -> available everywhere in same package
        // private -> available only in the class in which it was created
    }
}

class Subclass extends OtherClass {
    // This class inherits 'OtherClass'
    OtherClass OC = new OtherClass(); // public class accessible inside Subclass in same package
    // If we look at it closely, we can understand that this child class is also another class inside same package
    // So we can access public class of same package irrespective of where we access it is its own child class or not
    // Thus, we can use this logic and Main method example to say that 'NoModifier' class will also be accessible

    // Now, using 'super' keyword to check what types of data members we can access of the parent class in same package:
    int var1 = super.var1; // public variable accessible inside subclass in same package, Outcome: 9, Accessible: 8
    int var2 = super.var2; // protected variable accessible inside subclass in same package, Outcome: 10, Accessible: 9
    int var3 = super.var3; // no modifier variable accessible inside subclass in same package, Outcome: 11, Accessible: 10
    // int var4 = super.var4;
    // private variable NOT accessible inside subclass in same package, Outcome: 12, Non-Accessible: 2

    // The object of 'Subclass' can also be used to make the check:
    Subclass SC = new Subclass();
    int varA = SC.var1;
    int varB = SC.var2;
    int varC = SC.var3;
    // int varD = SC.var4; // no access to private

    static void subMethod() {
        Subclass SC = new Subclass();
        System.out.println(SC.var1+", "+SC.var2+", "+SC.var3);
    }
}

class Subclass1 extends OtherPkgClass { // A subclass in a different package
    // This class inherits 'OtherPkgClass'

    // More on classes from different packages:
    // Since, 'OtherPkgClass' which is a 'public' class in a different Package is already imported here
    OtherPkgClass OPC = new OtherPkgClass(); // we can access it even though it is in a different package
    // NoModifierOtherPkg NMOP = new NoModifierOtherPkg();
    // we cannot access it even after the 'import' because this class is not public
    // IMP: A single '.java' file can contain only 'ONE' public class

    // public variable accessible in subclass inheriting class from different package, Outcome: 13, Accessible: 11
    int var1 = super.var1;

    // protected variable accessible in subclass inheriting class from different package, Outcome: 14, Accessible: 12
    int var2 = super.var2;

    // no modifier variable NOT accessible in subclass inheriting class from different package, Outcome: 15, Non-Accessible: 3
    // int var3 = super.var3;

    // private variable NOT accessible in subclass inheriting class from different package, Outcome: 16, Non-Accessible: 4
    // int var4 = super.var4;

    // The object of 'Subclass1' can also be used to make the check:
    Subclass1 SC1 = new Subclass1();
    int varA = SC1.var1;

    int varB = SC1.var2;
    // IMP Point:
    // Only the 'Subclass' (in this case 'Subclass1') can access the protected data member when the original
    // class (in this case 'OtherPkgClass') is in a different package
    // Even the ORIGINAL class object (i.e. object of OtherPkgClass) cannot access the protected data member
    // inside a class that is in a different package
    // int varX = OPC.var2; will give an error

    // int varC = SC1.var3; // no access to no modifier variable
    // int varD = SC1.var4; // no access to private variable

    static void method() {
        Subclass1 SC1 = new Subclass1();
        System.out.println(SC1.var1+" "+SC1.var2);
    }
}

class OtherClass1 {
    // In this class we try to access data members of 'OtherPkgClass' even though this class does not inherit from it
    // As there is no inheritance, we cannot use the 'super' keyword and have to create an instance
    OtherPkgClass OPC = new OtherPkgClass();
    int var1 = OPC.var1; // public variable accessible from class in different package, Outcome: 17, Accessible: 13

    // protected variable NOT accessible from class in different package, Outcome: 18, Non-Accessible: 5
    // int var2 = OPC.var2;

    // no modifier variable NOT accessible from class in different package, Outcome: 19, Non-Accessible: 6
    // int var3 = OPC.var3;

    // private variable NOT accessible from class in different package, Outcome: 20, Non-Accessible: 7
    // int var4 = OPC.var4;

    // Thus, all possibilities from the chart were explored and the correctness of the chart was proved !
    static void method() {
        OtherClass1 OC1 = new OtherClass1();
        System.out.println(OC1.var1);
    }
}







