package _2_Implementation.FunctionsAndMethods;
import java.util.Arrays;   // required for 'Arrays', adds Array class.
public class ChangeValue {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};  // Non-primitive data-type, will get passed by value OF reference variable.
        // Strings are an exception, as they are final classes and are immutable.
        /* Note: passing copy of value assigned to reference variable (creating another identical object),
           passing value of reference variable(this case, pointing to same object in heap)
           and pass by reference(pointer pointing to actual memory address of variable) are different. */
        /* In Java, pass by copy of value of reference variable creates another identical object in heap
           only in case of Strings as, primitives are stored in stack itself and the variable in that function's scope
           points to that newly created identical object.
           Also, pass by value of reference variable makes the variable in that function's scope point to the
           same object in the heap, thus any change made by this variable also affects original variable as it
           points to the same object.
         */
        // In pass by reference, we provide actual memory address of the object to pointer variables which is the case in C/C++.
        // Here we are making the p_arr variable in replace() function point to the same object via copy of value of reference.
        System.out.println(Arrays.toString(arr));  // Before replacement, toString() converts array to String
        replace(arr); // Passing the whole array to function
        System.out.println(Arrays.toString(arr)); // Printing the whole array, element of index 0 & 1 are changed

        /* Note:
            Thus, references which are assigned by JVM, do not disclose the exact memory address of an object in memory
            and thus add a layer of security unlike pointers in C/C++.
            No arithmetic operations can be performed to manipulate references unlike C/C++ which has pointer arithmetic.
         */
    }

    static void replace(int[] p_arr) {
        // Now, p_arr -> Object(Array) <- arr
        p_arr[0] = 10;
        p_arr[1] = 20;  // The values will also be changed in main function
        // When a change is made through the p_arr variable, it is also reflected for arr as they both point to same object
    }
}
