package _2_Implementation.OOP._6_Generics_N_More;

import java.util.Arrays;

public class ObjectCloning {
    public static void main(String[] args) {
        RobotMaid robotMaid = new RobotMaid("Alice", 98000);
        System.out.println(robotMaid);

        // Creating a clone (shallow copy) using Constructor
        RobotMaid robotMaidTwin = new RobotMaid(robotMaid);
        System.out.println(robotMaidTwin);

        // Proving that we created a shallow copy using the Constructor:
        robotMaidTwin.functions[2] = "House-Monitoring";
        // Above change will be reflected in the 'functions' array for both objects
        System.out.println(robotMaid);
        System.out.println(robotMaidTwin+"\n");

        // Creating two clones using the overridden 'clone()' method
        /*
             We know from 'ExceptionHandling.java' that if there exists code that might throw an exception
             then the method in which the code is inside needs to use the 'throws' keyword followed by the
             (class name) name of the exception that might occur.
             (This is also done in the 'Robot Maid' class 'clone()' method as well).

             Following above logic, if we use the 'clone()' method inside our current 'main()' method
             then 'main()' method will also need to be followed by 'throws CloneNotSupportedException'

             To avoid this, we can make use of the 'try-catch' block as we have done below
         */
        try {
            // Shallow Copy:
            // need for typecast as '.clone()' returns Object class instance
            RobotMaid robotMaidTwin2 = (RobotMaid) robotMaidTwin.clone();
            // Proving shallow copying:
            robotMaidTwin.functions[2] = "Surveillance";
            System.out.println(robotMaidTwin);
            System.out.println(robotMaidTwin2+"\n");

            // Deep Copy:
            RobotMaidDeepClone robotMaidDC = new RobotMaidDeepClone("Alicia", 76000);
            System.out.println(robotMaidDC);
            // Creating the copy:
            RobotMaidDeepClone robotMaidDCTwin = (RobotMaidDeepClone) robotMaidDC.clone();
            System.out.println(robotMaidDCTwin+"\n");
            // Proving deep copying:
            robotMaidDCTwin.name = "AliciaTwin";
            robotMaidDCTwin.cost = 77000;
            robotMaidDCTwin.functions[2] = "House-Monitoring";
            System.out.println(robotMaidDC);
            System.out.println(robotMaidDCTwin+"\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// implementing 'Cloneable' for a class just tells the JVM that objects of that class support cloning
class RobotMaid implements Cloneable {
    String name;
    int cost;
    String[] functions;
    RobotMaid(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.functions = new String[]{"House-cleaning", "Cooking", "Surveillance"};
    }

    RobotMaid(RobotMaid other) {
        // This constructor is for copying details of other object to current object
        this.name = other.name;
        this.cost = other.cost;
        this.functions = other.functions;
        // as we are directly assigning array reference copy, both objects will point to same 'functions' array
        // Thus, this is also a 'shallow' copy
    }

    @Override // As '.clone()' method is actually defined in 'Object' class and every class inherits Object class
    public Object clone() throws CloneNotSupportedException {
        // we have to set return type to 'Object' and typecast each time
        // This is because we have to adhere to the return type set by the parent class 'Object' to make
        // use of the 'super.clone()' method

        // Returning shallow copy, which does not create a new copy of the 'objects' that belong to the
        // object type 'RobotMaid (in this case)' itself
        return super.clone();
    }

    @Override
    public String toString() {
        return this.name+"( Cost: "+this.cost+", Functions: "+ Arrays.toString(this.functions)+" )";
    }
}

class RobotMaidDeepClone extends RobotMaid implements Cloneable {
    RobotMaidDeepClone(String name, int cost) {
        super(name, cost);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // Returning deep copy, which creates a new copy of the 'objects' that belong to the
        // object of type 'RobotMaidDeepClone (in this case)' itself

        // First we get a new object by creating a shallow copy using 'super.clone()'
        RobotMaidDeepClone newObj = (RobotMaidDeepClone) super.clone();

        // Next we create new object copies of the objects belonging to the current 'RobotMaidDeepClone' object
        // We then replace the old object references with the newly created copied object references.
        newObj.functions = Arrays.copyOf(newObj.functions, newObj.functions.length); // creating copy of 'functions'

        return newObj; // returning the new object
    }
}

