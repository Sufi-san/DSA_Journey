package _2_Implementation.OOP._3_PrinciplesOOP;

public class InheritanceTypes {
    // Single Inheritance: One class is a parent for another derived class (Covered Earlier)
    // Multilevel Inheritance: A derived class itself is a parent of another class
}

class Species {
    boolean isExtinct;
    String planet;
    Species(boolean isExtinct, String planet) {
        this.isExtinct = isExtinct;
        this.planet = planet;
    }

}

class Human extends Species {
    String name
}

class Adult extends Human {

}

