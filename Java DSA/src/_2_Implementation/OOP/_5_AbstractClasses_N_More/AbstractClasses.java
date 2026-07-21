package _2_Implementation.OOP._5_AbstractClasses_N_More;

abstract class Parent{ // If class contains abstract methods it should be declared as abstract itself
    abstract void sayName(String name); // The abstract method, only accepts parameters, no arguments
    // When method is declared abstract, all sub/child classes will need to override the method

    /*
        If we definitely know that a method of parent class will always be overridden we declare it
        as abstract so that the actual object body is always defined in the child class
        Why do we do this?
        It increases code readability and the code looks cleaner
        Note: Just using abstract classes does NOT make multiple inheritance possible
     */
    void sayHey() {
        System.out.println("Hey");
    }
}

class Child1 extends Parent {
    String name;
    Child1(String name) {
        this.name = name;
    }

    // When the 'Parent' class type instance, initialized using 'Child' object will call '.sayName(String name)'
    // the below method will override the parent method and run in its stead
    @Override
    void sayName(String name) {
        System.out.println("Name: "+name);
    }
}

public class AbstractClasses {
    public static void main(String[] args) {
        Parent cObj = new Child1("Random Child"); // Here 'Parent' is an Abstract class
        cObj.sayName("Child1");

        /*
             When we try to create an actual parent object, we will always need to provide a body
             for the abstract methods first!! If not, then we will face errors
             This is because the parent object's method will not have a body and
             will also not be able to use the child methods
        */
        Parent pObj = new Parent() {
            @Override
            void sayName(String name) {
                System.out.println("I am the "+name+" class");
            }
        };
        pObj.sayHey();
        pObj.sayName("Parent");
        // For the same reason, we can also NOT create any abstract constructors!! (normal constructors can be present
        // inside abstract classes)
        // As static methods cannot be overridden we cannot create 'abstract static' methods (normal static methods can
        // be present inside abstract classes)
        // But abstract classes can contain normal or static methods
        // Also we cannot use 'final' with 'abstract' because we cannot override and change 'final'
    }
}
