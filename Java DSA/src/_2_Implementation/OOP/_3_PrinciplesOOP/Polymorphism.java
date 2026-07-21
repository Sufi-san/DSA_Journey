package _2_Implementation.OOP._3_PrinciplesOOP;

public class Polymorphism {
    // Poly: Many
    // Morphism: Ways to Represent
    // The ability of performing tasks or providing representations in many ways (Single Action Multiple Ways)
    // Languages that do not support polymorphism are not generally referred to as 'Object-Oriented'
    // Java Supports Polymorphism
    public static void main(String[] args) {
        /*
            Types of Polymorphism:

            1) (Compile Time) / Static Polymorphism -
                Achieved via Method Overloading
                (Same Name but types, number of arguments, ordering of types can be different)
                Eg: Multiple Constructors
                This is called 'Compile Time' Polymorphism because, the determination of which
                action will be performed out of all available ones, at run-time, is done at Compile Time.

            2) (Run Time) / Dynamic Polymorphism -
                Achieved by Method Overriding
                (When child class has a method which is exactly same as Parent class)
                Method overriding is a feature that allows a subclass (child class) to provide its own
                implementation of a method that's already defined in its superclass (parent class).
                The method checks inside classes happens at Run Time and hence it is 'Dynamic' Polymorphism.
         */

        // Constructor overloading itself is an example of Static Polymorphism just like method overloading
        Dog dog = new Dog(); // Runs the empty args constructor
        Dog dog1 = new Dog("Golden Retriever", 8); // Runs the constructor that supports 2 args

        // Method Overriding: methods with same name, types, params inside different classes
        Animal animal = new Animal();
        Cat cat = new Cat();
        // The function name is same for different objects (Act of representing same action in multiple ways)
        animal.define();
        dog.define();
        cat.define();
        // The function called by object, if present in its own class is given priority
        // The above statement holds true, even if the Class Type for the object is of parent class
        Animal dog2 = new Dog(dog1);
        dog2.define();
        /*
         We stay true to one of our previous statements, that what members can be accessed depend
         on the 'class type', which in above case is 'Animal'
         So how is 'dog2' accessing 'define()' method of 'Dog' Class ???
         It is not!
         If we remove the 'define()' method from 'Animal', dog2.define() will return an error,
         EVEN though 'define()' method is present in 'Dog' class
         So the reason that 'dog2' is able to access 'define()' method of 'Dog' class
         is due to 'method overriding' at RUN TIME (Dynamic Process)
         At run time, 'define()' is identified from the 'Animal' class, but then it is overridden
         by 'Dog' class 'define()'
         Conclusion:
         'WHAT can be accessed?' is defined statically by 'class type'
         'WHICH ONE is to be accessed?' is defined dynamically by the 'object type'
         */
        // How Java determines which method to call?
        /*
            By 'Dynamic Method Dispatch'
            It is a mechanism by which a call to an overridden method is resolved at run time rather than
            compile time
         */
        // Another example of Method Overriding:

        Object mouse = new Mouse();
        System.out.println(cat); // Will call the 'Object' class toString method
        System.out.println(mouse); // Will call the toString method defined inside 'Mouse' class due to overriding

        /* Final Keyword:
            IMP:
            'final' methods cannot be overridden
            'final' classes cannot be extended (no inheritance)
            When a class is declared final, its methods will also become final
        */

        // Static methods: can be inherited but cannot be overridden
        // Why? Because even if we use a child object to call parent static method (which is bad convention)
        // (Assuming that we created the child object using the 'Parent' class type)
        // It will always get called, even if the child class itself contains the same static method
        // Now, to access the child class static method we can either use objects of that child class itself
        // (This time declared using their own class type)
        // or its children(classes that extend it) or following proper convention, we call it using
        // the class name itself

        // Eg: We have 'Animal dog2 = new Dog(dog1);' above
        dog2.makeSound(); // This will call makeSound() of the 'Animal' class
        // Above statement proves that, (static methods can be inherited but cannot be overridden)
        // Also we have 'Dog dog = new Dog();' above
        dog.makeSound(); // This will not call makeSound() of 'Animal' class but of 'Dog' Class

        // No confusion while calling static methods using class names: they always call their own methods
        // irrespective of same names
        Dog.makeSound();
        Animal.makeSound();
        // In short: 'overriding' depends on objects, 'static' components do not depend on objects
        // hence we cannot override static methods

        // Note: Overloading and Overriding both apply to methods and NOT Instance Variables
        // No Overloading variables, due to the basic rule of not declaring multiple variables of same name
        // in single scope
        // No Overriding variables, because of the 'class type' concept we studied in 'Inheritance.java'
    }
}

class Animal {
    void define() {
        System.out.println("I am an animal");
    }

    static void makeSound() {
        System.out.println("**Random Animal Noises**");
    }
}

class Dog extends Animal {
    String breed;
    int age;
    static String sound = "Woof";

    static void makeSound(){
        System.out.println(Dog.sound+" !!");
    }

    @Override // This is the 'override' annotation
    // It is not mandatory to write it above the overridden methods
    // However, it is good convention and serves as a 'check' to whether or not the below method is overridden
    void define() { // Runs when object of Dog is created, and hence it 'overrides' the parent method
        System.out.println("\nAnimal is Dog");
        System.out.println("Details -\n"+"Breed: "+this.breed+"\nAge: "+this.age+"\n");
    }

    Dog() {
        this.breed = "Unspecified";
        this.age = -1;
    }

    Dog(String breed, int age) {
        this.breed = breed;
        this.age = age;
    }

    Dog(Dog obj) {
        this.breed = obj.breed;
        this.age = obj.age;
    }
}

class Cat extends Animal {
    void define() {
        System.out.println("Animal is Cat");
    }
}

class Mouse extends Animal {
    String sound;
    String color;
    Mouse() {
        this.sound = "Squeak";
        this.color = "Grey";
    }

    @Override // Indicates that overriding method is valid
    public String toString() {
        return "Mouse{Sound = "+this.sound+", Color = "+this.color+"}";
    }
}
