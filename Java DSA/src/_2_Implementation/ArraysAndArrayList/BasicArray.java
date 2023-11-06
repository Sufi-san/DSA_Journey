package _2_Implementation.ArraysAndArrayList;

public class BasicArray {
    public static void main(String[] args) {
        // An array is collection of elements of similar type
        // Array Syntax:
        // datatype[] variable_name = new datatype[size];
        // Q. Store 5 numbers (we create an array instead of 5 variables)
        int[] roll_num = new int[5];
        // 'new' is a keyword used to create an object.
        System.out.println(roll_num[4]);  // this will print 0
        // when there is no element allocated, element at that index is 0
        // for directly:
        roll_num = new int[] {23, 45, 67, 89, 34};
        // roll_num = {23, 45, 67, 89, 34} gives error as array initializer is only allowed when it is declared (like line 9).
        System.out.println(roll_num[4]); // this will print 34
        // Note: all elements must be of similar type in an array.

        String[] arr = new String[5];
        System.out.println(arr[3]); // will print 'null'.
        // for String arrays the default element is 'null'.
        // null is a special literal, however, it cannot be used as a type for variables.
        // null also cannot be assigned to primitive data types such as int,float etc.
        // null can be compared to 'None' in Python.

    /* Breakdown:
        int[] roll_num;
          // declaration of array. roll_num is getting defined in stack as a reference variable of type array. (compile time)
        roll_num = new int[5];
          // initialization of array, the actual object is being created in heap memory. (run time)
          // This is known as dynamic memory allocation
        Heap objects are not continuous, thus unlike C, allocation of memory completely depends on JVM.
        Hence, internally array objects in java may not be continuous.

        Note:
        Primitives are directly stored in stack memory
        Self-made objects or non-primitive types are stored in heap memory
     */
    }
}
