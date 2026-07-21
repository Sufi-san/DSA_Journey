package _2_Implementation.OOP._2_Packages_N_Classes; // <-- This is a package, they allow us to collect and/or segregate java files
// Code gets compartmentalized
// In simple terms, it is just a folder
// Different packages can contain classes of the same name
// We can 'import'\ files from different packages and reuse the code in the current file
import static _2_Implementation.OOP._1_Basics.Introduction.message;
// For classes inside the same package, we can reuse code without import statements by either
// simply mentioning the other class' name with '.' separator(for static content) or instantiating an
// object of that class

// If we know the file/folder structure, we can access content of any class in one location inside another class
// with the help of import statements or '.' separators.
// Eg: 1) 'import java.util.Scanner;' and then create its object 'Scanner in = new Scanner(System.in);'
// OR  2) Simply mention the path while creating the object, 'java.util.Scanner in = new Scanner(System.in);'
// More on packages later...


public class Packages_N_Static {
    public static void main(String[] args) {
        message(); // static method from '_1_Introduction' class used with the help of 'import' statement

        Example obj = new Example("Example-1");
        System.out.println(obj.name);
        // properties not logically related to the objects, but are common to all objects of a class are 'static'
        // static properties cannot be accessed by instantiated objects, but we use the class itself to access them
        System.out.println("Object Count: "+Example.examplePopulation);
        Example obj2 = new Example("Example-2");
        System.out.println(obj2.name);
        System.out.println("Object Count: "+Example.examplePopulation);
        // 'obj2.examplePopulation' Will check if object contains 'examplePopulation', as it does not then
        // class variable is updated
        System.out.println(obj2.examplePopulation); // Not recommended, we use class name by convention

        // Why main method is static?
        // 'main' method is the first thing that runs when we execute a java program
        // Thus, it is mandatory for a program to contain the 'main()' method for running
        // As we want to use the this main() method without instantiating an object of its class, it is static.

        // Inside a static method, we cannot use any non-static method.
        // Eg: we cannot call 'greeting()' here without creating an object of class 'Packages_N_Static'
        Packages_N_Static obj3 = new Packages_N_Static();
        obj3.greeting();

        // Initializing static variables using a static block
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
        // Whenever a class is referenced, all static elements are acknowledged first

        // Creating the object of a class that allows only one instance to be created
        // SingletonClass singleObj = new SingletonClass(); will give error as Constructor is declared private
        SingletonClass singleObj = SingletonClass.getInstance();
        SingletonClass singleObj2 = SingletonClass.getInstance();
        // both of the above reference variables point to the same object
        System.out.println("\nsingleObj Details -\n"+singleObj);
        System.out.println("\nsingleObj2 Details - \n"+singleObj2);
    }

    // Static can be accessed inside non-static, but not vice-versa
    // Non-static methods however, can contain other non-static methods because, in the end an object must
    // be created for accessing that first non-static method
    void greeting() {
        System.out.println("Hello");
        greeting2(); // using a static method
        greeting3();
    }

    static void greeting2() {
        System.out.println("Hello, from static method.");
    }

    void greeting3() {
        System.out.println("Hello, from another non-static method, sharing the same object.");
    }
}

class Example {
    String name;
    static int examplePopulation = 0; //
    Example(String name) {
        this.name = name;
        Example.examplePopulation += 1; // Every time an example object is created the count increases
        // As it is static, it stays updated for every new object and does not revert back to default value
        // As no object instance can access static values, we do not need to use 'this' keyword
        // We can just use 'examplePopulation' here too
        // Even if we use 'this' it will still work correctly as, if the object doesn't have the selected
        // variable then the class is checked and it will be found

        // The concept stays the same for methods as well
        Example.greeting(this.name);
        // The 'this' keyword above is not inside the greeting() body, it is just used as an argument here
        // to pass the object's name.
    }

    static void greeting(String name) {
        System.out.println("Hello, "+name+" object was created successfully!");
    }
}

class StaticBlock {
    static int a = 4;
    static int b;
    static { // A static block runs exactly once the first time the class is loaded for the first time
        System.out.println("Static Block Runs");
        b = 5 * a;
    }
}
