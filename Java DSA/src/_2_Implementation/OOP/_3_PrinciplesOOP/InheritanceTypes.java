package _2_Implementation.OOP._3_PrinciplesOOP;

public class InheritanceTypes {
    // Single Inheritance: One class is a parent for another derived class (Covered Earlier)
    public static void main(String[] args) {
        // Multilevel Inheritance: A derived class itself is a parent of another class
        WeightLifter wLiftObj = new WeightLifter(false, "Earth", "Sufi", 22, 150, false);
        System.out.println(wLiftObj.isExtinct); // WeightLifter object has access to Species instance variable

        // Multiple Inheritance: One class extends more than one class
        // Not supported by Java due to ambiguity
        // Concept can be implemented using 'Interfaces' will be explained later

        // Hierarchical Inheritance: One class is inherited by multiple classes, thus a hierarchy is created.
        Doctor docObj = new Doctor(false, "Earth", "Hamid", 50, "Opthalmology", 10000);
        System.out.println(docObj.age); // The doctor object also has access to Human class 'age' instance variable
        System.out.println(wLiftObj.age); // The weight lifter object also has access to Human class 'age' instance variable
        // The structure of the class Inheritance Hierarchy up till this point is thus:
        /*
                                                    Species
                                                       |
                                                     Human
                                                       |
                                               ------------------
                                               |                |
                                           Doctor           WeightLifter
         */

        // Hybrid Inheritance: Combination of Single and Multiple Inheritance, not supported in Java for similar reasons
        // Will be explained with 'Interfaces' later

        // Cyclic Inheritance:  A class inherits itself. Not supported due to no requirement.
    }

}

class Doctor extends Human {
    String specialisation;
    double salary;
    Doctor() {
        super();
        this.specialisation = "Not Specified";
        this.salary = 50000;
    }

    Doctor(boolean isExtinct, String planet, String name, int age, String specialisation, double salary) {
        super(isExtinct, planet, name, age); // calls Human constructor
        this.specialisation = specialisation;
        this.salary = salary;
    }
}

class Species {
    boolean isExtinct;
    String planet;
    Species() {
        this.isExtinct = false;
        this.planet = "Earth";
    }
    Species(boolean isExtinct, String planet) {
        this.isExtinct = isExtinct;
        this.planet = planet;
    }

}

class Human extends Species {
    String name;
    int age;
    Human() {
        super();
        this.name = "Not Mentioned";
        this.age = -1;
    }
    Human(boolean isExtinct, String planet, String name, int age) {
        super(isExtinct, planet); // calls Species constructor
        this.name = name;
        this.age = age;
    }
}

class WeightLifter extends Human {  // Multilevel Inheritance
    int liftCapacity;
    boolean isProfessional;
    WeightLifter() {
        super();
        this.liftCapacity = 50;
        this.isProfessional = false;
    }

    WeightLifter(boolean isExtinct, String planet, String name, int age, int liftCapacity, boolean isProfessional) {
        super(isExtinct, planet, name, age); // calls Human constructor
        this.liftCapacity = liftCapacity;
        this.isProfessional = isProfessional;
    }
}

