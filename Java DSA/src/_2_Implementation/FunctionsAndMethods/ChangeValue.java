package _2_Implementation.FunctionsAndMethods;
import java.util.Arrays;   // required for 'Arrays', adds Array class.
public class ChangeValue {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};  // Non-primitive data-type, will get passed by value OF reference variable.
        /* Note: passing copy of object whose reference is held by reference variable (creating another identical object),
           passing value of reference variable (this case, pointing to same object in heap)
           and pass by reference (pointer pointing to actual memory address of variable) are different. */
        /* In Java, pass by COPY of object whose reference is held by reference variable creates another identical object
           in heap. Thus, a new reference is created for this copied object and is passed to the method, this reference is
           held by the reference variable in that method.
           Passing the value of reference variable directly (without making another identical object with new reference)
           makes the variable in that function's scope point to the same object in the heap, thus any change made by this
           variable also affects object whose reference is held by original variable as both of them now store the same
           reference and hence point to the same object in heap memory.
         */
        // Strings are an exception when trying to modify the object, as they are final classes and their instance variable
        // values are final as well. They do not provide any 'setter' methods to change instantiated object values too.
        // Hence, String objects are immutable.

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
