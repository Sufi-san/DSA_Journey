package _2_Implementation.OOP._1_Basics;

class SpecialStudent {
    String name;
    int rNum;
    float marks;
    final boolean isElite = true;
    // Use of final keyword ensures that all objects instantiated from 'SpecialStudent' class
    // have value of boolean variable 'isElite' as 'true' at all times, and it cannot be changed.

    // Constructor defined for the class 'SpecialStudent' that executes when an object is created
    // Now while creating the object, the 3 parameters mentioned below will be compulsorily required
    SpecialStudent(String name, int rNum, float marks) {
        // Here is the true use of 'this' keyword, as parameters and instance variables have same names
        // the 'this' keyword specifies that we are referring to the instance variable for the instantiated object
        // If we do, SpecialStudent s1 = new SpecialStudent("alpha", 3, 89.8f), 'this' stands for 's1'
        if(this.isElite) this.name = name + " Elite"; // s1.name
        this.rNum = rNum; // s1.rNum
        this.marks = marks; // s1.marks
    }

    SpecialStudent(String name) {
        if(this.isElite) this.name = name + " Elite";
    }

    SpecialStudent(Student std) {
        if(this.isElite) this.name = std.name + " Elite";
        this.rNum = std.rNum;
        this.marks = std.marks * 0.01f + 100;
    }

    SpecialStudent() {
        this ("Anonymous", 99, 69.69f); // This will call another constructor according to arguments
        // Internally it is like: new SpecialStudent("Anonymous", 99, 69.69f);
    }

    void printInfo() {
        // 'this' keyword ensures that we are referring to the current object instance while calling the method
        System.out.println("\n\nStudent Details:\n");
        System.out.println("Name: "+this.name);
        System.out.println("Roll Number: "+this.rNum);
        System.out.println("Marks: "+this.marks);
    }
}
