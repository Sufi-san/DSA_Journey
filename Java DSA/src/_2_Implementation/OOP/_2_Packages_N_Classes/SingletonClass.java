package _2_Implementation.OOP._2_Packages_N_Classes;

class SingletonClass { // A class that allows creation of ONLY ONE instance
    String name;
    int iD;
    static SingletonClass instance; // This static variable will store reference to 'SingletonClass Object'

    // The below constructor can now, only be accessed inside this class
    private SingletonClass(int iD, String name) { // 'private' will be further explained in access specifiers section
        this.iD = iD;
        this.name = name;
    }

    static SingletonClass getInstance() {
        if(SingletonClass.instance == null) { // If no prior instance is created, create new instance
            instance = new SingletonClass(123, "Single Object");
        }
        return instance; // If non-null instance exists, return the same instance reference
    }

    public String toString() {
        return "Object ID: "+this.iD+"\nObject Name: "+this.name;
    }
}
