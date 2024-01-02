package _2_Implementation.OOP._5_AbstractClasses_N_More;

 /*
     - interface variables are static and final by default
     - interfaces cannot be used to create objects, they are not classes, that is why default 'static'
     - interfaces thus, do not have any 'instance' variables
     - interfaces do not allow constructors, that is why 'final' (variables need to be initialized always)
     - methods inside interfaces are abstract and public by default, though there are few exceptions
     - We can create 'default' methods inside interfaces, whose body(implementation) must be provided
     inside the interface scope itself
     - These methods can be used by all objects of classes where the interface is implemented, and it is not
     mandatory to override them
     - We can create 'static' and/or 'private' methods inside interfaces, a single method
     can be 'static' and 'private' at the same time
     - Such methods inside the interface might be of aid to other 'default' methods, they always require a body
     even if they are a function inside the interface scope.
     - 'default' methods themselves can not be 'private'
     - It is advisable to always keep such aid methods 'private' to prevent them from being overridden by
     other classes and to prevent their use by other objects
  */

interface Engine {
    void start();
    void stop();
    void accelerate();
}

interface Brake {
    default void brake() { // This functionality of default methods for interfaces was added later in Java
        System.out.println("Break has been applied.");
    }
}

class Car implements Engine, Brake { // <-- This was not possible before by just using abstract classes

    // Thus, interface allows a form of multiple inheritance
    @Override // <-- Annotations such as this are also internally 'interfaces'
    public void start() {
        System.out.println("Car Engine has started.");
    }

    @Override
    public void stop() {
        System.out.println("Car Engine has stopped.");
    }

    @Override
    public void accelerate() { System.out.println("Car Engine is accelerating.");}

    // We can override the 'default' method from 'Brake' if necessary.
}

interface Motor {
    void start();
    void accelerate();
    void stop();
}

interface MediaPlayer {
    void start();
    void stop();
}

class ElectricMotor implements Motor {
    public void start() {
        System.out.println("Electric Motor has started.");
    }

    public void accelerate() {
        System.out.println("Electric Motor has accelerated.");
    }

    public void stop() {
        System.out.println("Electric Motor has stopped.");
    }
}

class CDPlayer implements MediaPlayer {
    public void start() {
        System.out.println("CD Player has started.");
    }

    public void stop() {
        System.out.println("CD Player has stopped.");
    }
}

class ElectricCar {
    ElectricMotor motor;
    CDPlayer mediaPlayer;

    ElectricCar(ElectricMotor motor, CDPlayer mediaPlayer) {
        this.motor = motor;
        this.mediaPlayer = mediaPlayer;
    }

    void brake() {
        System.out.println("Brake Applied. The car has stopped.");
    }

    void startMotor() {
        this.motor.start();
    }

    void accelerate() {
        this.motor.accelerate();
    }

    void stopMotor() {
        this.motor.stop();
    }

    void startCDPlayer() {
        this.mediaPlayer.start();
    }

    void stopCDPlayer() {
        this.mediaPlayer.stop();
    }
}

public class Interfaces {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.start(); // Using an 'Engine' interface method overridden in 'Car' class
        car1.stop(); // Using an 'Engine' interface method overridden in 'Car' class
        car1.accelerate(); // Using an 'Engine' interface method overridden in 'Car' class
        car1.brake(); // Using the default method from 'Brake' interface

        // The question now is, why to override ?? Why not just simply declare these methods inside the class 'Car'
        // from the get-go instead of creating Interfaces Engine and Brake and override their methods?
        /* Ans:
             To enforce a contract on to the classes which are implementing the interfaces is the
             key characteristic as well as need for those interfaces.
             If we know the functions and common characteristics for some things but are unsure about how exactly
             those will work, we use interfaces to establish contracts such that if any class wants to implement
             that interface, then they will 'compulsorily' need to define the respective methods and properties.

             The ideology behind the 'contract' establishment stays the same for 'abstract' classes too.
             In case of abstract classes, we know some of the functions or properties for that particular class that
             will never change, and hence we can declare implementation (non-abstract methods) for those along
             with the abstract methods (undetermined implementation) that might be implemented differently based on
             the subclass type.
         */

        // What if two or more of the implemented interfaces have methods of same names ??
        /* Ans:
            We can override it once using the same name as in all the interfaces, and it will satisfy
            the overriding requirement for all the interfaces as well as that single overridden method
            will run irrespective of which interface's method the user intended to call.

            OR (as above approach would be just ignoring the similarity)

            We can create classes for every interface, and instantiate all the objects of those classes
            for a single object of our main class.
            Now we can define some methods that will determine which interface's method the user wants
            to call. Inside those methods, we make use of the sub-objects that we instantiated and use
            them to call their respective methods
         */
        // The example for the second approach from above is as follows:
        // In below example, interfaces 'Motor' and 'Media Player' are used and have same method names
        // 'start' and 'stop'
        // The conflict however is resolved using the second approach

        System.out.println();
        ElectricCar eCar = new ElectricCar(new ElectricMotor(), new CDPlayer());
        eCar.startMotor();
        eCar.startCDPlayer();
        eCar.accelerate();
        eCar.stopMotor();
        eCar.brake();
        eCar.stopCDPlayer();

        // Nested Interface Example: (Interface is in a different file)
        // The nested interfaces can be declared as 'public', 'protected', 'private' or with No modifier
        // But interfaces which are not inside any scope can not be 'protected' or 'private'.
        // Also interfaces not inside any scope, can be public only if they match the name of the file
        // thus, only one public interface per file.
        Nested2 obj = new Nested2();
        String[] strArr = {"Sufiyan", "AfifA"};
        for(String str: strArr) {
            System.out.println(obj.isPalindrome(str.toLowerCase()));
        }

    }
}
