package _2_Implementation.StringAndStringBuilder;

import java.util.Arrays;

public class OutputAdvanced {
    public static void main(String[] args) {  // How Java prints values of different types... overloading println()
        // Anything we put inside the println() function, calls the toString() method.
        String name = null;
        System.out.println(name);  // null literal , null has no toString() method.
        System.out.println(56);  // int type , Integer.toString(), same for Long, Double, Float
        System.out.println("Sufi");  // String type
        System.out.println(new int[]{1,2,3,4,5,6}); // Object type , since object can be any type, random value printed
        // Every object has a default representation, it takes hash code, adds @ to it and adds some random characters.
        // However, it is not beneficial for human readability. Thus, Pretty Printing is  required.

        // Example of Pretty Printing: Making java use a toString() from a specific class.
        System.out.println(Arrays.toString(new int[]{1,2,3,4,5,6}));  // Here the function is over-ridden.
        // Due to this, the println() function treats the object as normal String type, and it gets printed.
        // We can also make our own toString() methods.
    }
}
