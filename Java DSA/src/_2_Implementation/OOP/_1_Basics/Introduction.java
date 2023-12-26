package _2_Implementation.OOP._1_Basics;

// All notes are present in '_1_Notes/15_OOP' so we focus on only implementation
// Some comments will be present if those are important to understand the implementation

public class Introduction {
    public static void main(String[] args) {
        // Using a single entity to store multiple types of data specific to that entity
        // The blueprint or template for such an entity is called 'Class'
        // The actual entity created at runtime and which occupies actual memory, is the object
        Student st1 = new Student(); // st1 stores the reference to the actual object stored inside the memory
        st1.name = "Sufiyan";
        st1.rNum = 6;
        st1.marks = 90.5f;
        st1.printInfo();

        // For storing multiple such Student objects:
        Student[] stdArr = new Student[3];
        for(int i = 0; i < stdArr.length; i++) stdArr[i] = new Student(); // Initializing objects

        stdArr[0].name = "Vivek";
        stdArr[0].rNum = 29;
        stdArr[0].marks = 100;
        stdArr[1].name = "Onkar";
        stdArr[1].rNum = 28;
        stdArr[1].marks = 99.2f;
        stdArr[2].name = "Nimesh";
        stdArr[2].rNum = 20;
        stdArr[2].marks = 93.5f;
        for(Student st: stdArr) st.printInfo();

        // The above method however, gets a bit cumbersome, to resolve this we have 'Constructors'
        // These are special functions inside a class that execute whenever an object of that class is instantiated
        // If no specific constructor is created, java uses a default empty constructor
        // If a constructor is defined inside a class, we need to compulsorily provide required parameters
        // while instantiating object

        SpecialStudent st2 = new SpecialStudent("Sufi", 69, 100.1f);
        // name, roll number and marks required for instantiating SpecialStudent object
        st2.printInfo();

        // Constructors can be overloaded similar to methods inside a class
        SpecialStudent st2b = new SpecialStudent("Vivek");
        st2b.printInfo();

        // Constructor that uses another object for instantiating a new object
        SpecialStudent st2c = new SpecialStudent(stdArr[1]);
        st2c.printInfo();

        // Constructor that calls another constructor
        SpecialStudent st2d = new SpecialStudent();
        st2d.printInfo();
        System.out.println();

        // Primitives are not initialized as objects in heap memory, but we can use 'Wrapper' classes
        // to initialize them as objects
        Integer num = 45; // same as 'Integer num = new Integer(45);'
        Integer num2 = 46;
        System.out.println(num.equals(num2 - 1)); // If 'num' was primitive type 'int', we couldn't have used .equals()
        System.out.println(num2.equals(num + 1));
        swap(num, num2); // So now we pass by 'copy of value of reference'
        System.out.println("But in the main function: (Still not swapped)");
        System.out.println("num = "+num+", num2 = "+num2+"\n");
        // This happened because the class 'Integer' is a 'final' class
        // 'final' keyword is similar to 'const' of JavaScript, it prevents modification of content
        // Similar to 'const', 'final' also requires variable to be initialized at time of declaration
        // Eg: 'st2b.isElite = false;' will return an error, because 'isElite' is final in SpecialStudent
        // Eg2:
        final Student lastStd = new Student();
        lastStd.name = "Last Student"; // Even though the object is final, we can change its properties
        // What we cannot change, is the 'lastStd' variable that stores the object reference copy
        // lastStd = new Student(); <-- This will return error
        // More about 'final class' will be explained later

        /*
            Java has garbage collection, so it handles destruction of unused objects automatically, and
            we cannot do it manually.
            However, we can manually control what happens 'when' the object is being destroyed.
            Example is as given below:
         */
        for(int i = 0; i < 167000; i++) { // uncomment 'protected void finalize()...' in class Student() to check
            Student stud = new Student();
            stud.rNum = i;
        }
    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
        System.out.println("Inside swap function scope: (We have Swapped values)");
        System.out.println("a = "+a+", b = "+b);
    }

    public static void message() { // Static function to be used in future
        System.out.println("Learning OOP from Kunal");
    }

}

class Student { // The blueprint for creating student objects
    int rNum;
    String name;
    float marks;

    // In this class constructor is not separately defined and hence it is treated as empty
    /*
        Student(){
            ## Empty Constructor ##
        }
     */
    void printInfo() {
        // 'this' keyword ensures that we are referring to the current object instance while calling the method
        System.out.println("\n\nStudent Details:\n");
        System.out.println("Name: "+this.name);
        System.out.println("Roll Number: "+this.rNum);
        System.out.println("Marks: "+this.marks);
    }

    // 'protected' and 'throws' will be explained later
    // protected void finalize() throws Throwable { System.out.println("Object is destroyed. 'i' = "+this.rNum); }
    // about to be deprecated but works for now, uncomment above line to check

}










