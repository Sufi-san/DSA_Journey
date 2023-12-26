package _2_Implementation.OOP._3_PrinciplesOOP;

public class Inheritance {
    public static void main(String[] args) {
        Quadrilateral q1 = new Quadrilateral();
        Quadrilateral q2 = new Quadrilateral(4.2);
        Quadrilateral q3 = new Quadrilateral(q2);
        Quadrilateral q4 = new Quadrilateral(5.6, 7.8);
        System.out.println(q1+" "+q2+" "+q3+" "+q4);
        // Some Experiments:

        // The number of members accessible by the object is determined by the 'class type'
        // Below, although q5 will point to a Square object, as Quadrilateral can only access 'w'(width),
        // it cannot access the 'a'(area) of Square object
        Quadrilateral q5 = new Square(3);
        // q5.l; will return error due to 'l' being private for Quadrilateral
        System.out.println("Width of Square: "+q5.w); // will return width
        // q5.a; will return error due to class type being Quadrilateral

        // Square q6 = new Quadrilateral(); <-- This line will also result in an error
        // As we know, the 'class type' determines the members or properties accessible via an object,
        // It is necessary for Square objects to be able to access 'a'(area).
        // But Quadrilateral objects do not possess such an instance variable !

        Square s1 = new Square();
        System.out.println(s1); // Uses the inherited 'toString' method of 'Quadrilateral' class
    }
}

class Quadrilateral {
    // private keyword ensures that, this instance variable cannot be accessed by child class objects
    private double l; // length;
    double w; // width;

    Quadrilateral() {
        // The 'super' keyword provides access to properties of direct parent of a class (Class just above current)
        super(); // This won't return an error even though it inherits no class here
        // Why? Because every class by default, extends the 'Object' class in Java,
        // ctrl + left-click on super() to check
        this.l = this.w = -1;
    }

    Quadrilateral(double side) {
        this.l = this.w = side;
    }

    Quadrilateral(double l, double w) {
        this.l = l;
        this.w = w;
    }

    Quadrilateral(Quadrilateral old) {
        this.l = old.l;
        this.w = old.w;
    }

    public String toString() {
        return "\nLength: "+this.l+"\nWidth: "+this.w+"\n";
    }
}

// Square is the child class or subclass of Quadrilateral
class Square extends Quadrilateral { // Square inherits all properties of Quadrilateral except the private ones
    double a; // area, exclusive to Square, cannot be accessed by Quadrilateral
    Square() {
        super(); // Why do we initialize 'super()' first and not after 'this.a = -1' ??
        // Because any child class object may require parent class object properties
        // However, to make that possible, we need to first initialize parent properties
        // This, is why we first call the parent class constructor inside child constructors
        this.a = -1;
    }
    Square(int side) {
        super(side); // 'super()' Calls corresponding constructor of 'Quadrilateral' class
        this.a = side * side;
    }
}

