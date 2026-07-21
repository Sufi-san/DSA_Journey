package _2_Implementation.OOP._2_Packages_N_Classes;

public class InnerClasses {
    // Note: External classes at the outermost level, cannot be 'static'
    //       But, inner classes can be static

    static class InsideClassStatic {
        String name;
        InsideClassStatic(String name) {
            this.name = name;
        }

        // Defining an internal toString method to print the object of class 'InsideClassStatic'
        // Note: this method cannot be static
        // More details about this will be covered in Method Overriding
        public String toString() {
            return "Object Name: "+this.name;
        }
    }

    class InsideClassNonStatic {
        String name;
        InsideClassNonStatic(String name) {
            this.name = "Inner "+name;
        }
    }

    public static void main(String[] args) {
        // 'InsideClassNonStatic obj = new InsideClassNonStatic(); will return an error because it is non-static
        // As it is non-static, it is dependent on the objects of class 'InnerClasses'
        // So we can access both classes as -

        // For static nested class:
        InsideClassStatic obj1 = new InsideClassStatic("InsideClassStatic Object");
        // Above statement is same as:
        // InnerClasses.InsideClassStatic obj1 = new InnerClasses.InsideClassStatic("Static Inside Class Object");
        System.out.println(obj1.name);

        // For non-static nested class:
        InnerClasses outerObj = new InnerClasses();
        InsideClassNonStatic obj2 = outerObj.new InsideClassNonStatic("InsideClassNonStatic Object");
        // As 'InsideClassNonStatic' is not static, it is dependent on the 'objects' of the outer class to create
        // its own objects

        // Using custom toString() method
        // The println() method is responsible for invoking the toString() method and
        // it first checks whether, object has toString() method, if not then it checks the
        // class, if still not then it checks the core java files & packages and uses the default toString() for objects
        System.out.println(obj1);
    }
}
