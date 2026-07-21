package _2_Implementation.StringAndStringBuilder;
import java.util.Arrays;
public class Strings {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5};  // can be changed, object in heap is modified
        arr[2] = 8;
        System.out.println(Arrays.toString(arr));
        String name = "Sufiyan Chougule";  // Immutable, cannot be changed, object in heap cannot be modified.
        System.out.println(name);  // Simple Printing

        // String is the most commonly used class in java class library
        // Everything that starts with a capital letter at the beginning is a class.
        // Every String we create is an object of type String.

        // About String Immutability:
        /* Concepts:
            1) String Pool: It is a separate memory structure inside the heap containing the objects
                            whose reference is stored in reference variables.
                            All Similar values of String are not recreated in the pool, Saving memory.
                            This makes program more optimised.
            2) String Immutability:  Even though reference variables point to the same object in String pool,
                                     unlike arrays, the object cannot be modified and hence there can be no
                                     change made via any reference variable.
                                     In case we change an old reference variable, a new object will be created
                                     in the pool, and it will point to that new object instead of changing the
                                     old one. The old object will then be erased by the garbage collector if it
                                     is not used by any other reference variable to free memory space.
         */
        String name1 = "Shubham";
        String name2 = "Shubham";  // Pointing to same 'Shubham' in String Pool
        System.out.println("name1: "+name1+" & name2: "+name2+" are the same object in String Pool.");
        // Why are Strings Immutable?
        // Short Answer: for security
        /* If strings were not immutable, then if one string object to which different variables were pointing
           was changed, then it would have been changed for all the reference variables. */
    }
}
