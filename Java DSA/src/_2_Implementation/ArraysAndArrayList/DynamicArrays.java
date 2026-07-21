package _2_Implementation.ArraysAndArrayList;
import java.util.Scanner;
import java.util.ArrayList;  // ArrayList Class for Dynamic Array
public class DynamicArrays {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        // ArrayLists are slower than the standard array, however in an arraylist we can allocate memory for elements dynamically multiple times.
        // Memory Storage of ArrayList is similar to array, but it does not accept primitive datatype.
        // The elements inside an ArrayList are thus objects of 'wrapper classes'.
        // Wrapper Classes are used when we require to store primitive data-types in structures requiring object inputs.
        /* Why size is not fixed for dynamic-arrays/arraylist.
           1) Size is actually fixed internally.
           2) When the initial arraylist is filled by some amount,
              It will create a new arraylist of say, double the size(there exists a formula for that in ArrayList Class).
              Old elements from initial arraylist will be copied in the new one.
              Old/Initial arraylist is deleted.
         */
        ArrayList<Integer> list = new ArrayList<>(10);  // Initial Capacity is the default capacity of array.
        // This means Initial Arraylist in memory will have a capacity for 10 elements.
        // <Integer> is a 'generic', a wrapper class which declares what type of elements will the array contain.
        list.add(88);list.add(89);list.add(87);list.add(86);list.add(85);list.add(56);list.add(77);list.add(83);
        list.add(45);list.add(25); // 10 elements added to ArrayList (initial size)
        list.add(57);  // initial capacity does not matter.
        // Other methods in ArrayList Class can also be accessed using the 'list' object.
        /* list.add(element) -> adds element to the end of arraylist
           list.set(index, element) -> updates element at a given index in arraylist
           list.get(index) -> gets a single element at specified index in arraylist.
           list.contains(element) -> returns boolean value depending on whether element is present in arraylist
           list.remove(index) -> removes element at specified index in arraylist.
           list.size() -> similar to .length for arrays, it returns the size of the arraylist.
         */
        System.out.println(list);
        boolean hasElement = list.contains(57);  // Checks if element exists in arraylist.
        System.out.println(hasElement);
        list.set(1, 33);  // Element at Index 1 will be changed to 33
        System.out.println(list);
        list.remove(1);  // Takes index and removes element at that Index.
        System.out.println(list);  // No toString() method required here, as it already internally calls toString().

        // Taking Input from user and printing
        System.out.println("Enter 5 elements: ");
        for (int i = 0; i < 5; i++) {  // Adding 5 elements via loop and user input.
            list.add(s1.nextInt());
        }
        System.out.println(list);
        
        // Taking Input at specific indices:
        System.out.println("Enter 5 elements");
        for (int i = 0; i < 5; i++) {
            list.set(i, s1.nextInt());
        }

        // For printing using for loop, here the list[index] syntax will not work for arraylist object
        for (int i = 0; i < list.size(); i++) {   // list.size() returns the length of the arraylist
            System.out.print(" "+list.get(i));  // list.get() returns element at the mentioned index.
        }
        System.out.println();
        // Enhanced for loop:
        for(int element: list){
            System.out.print(" "+element);
        }
    }
}
