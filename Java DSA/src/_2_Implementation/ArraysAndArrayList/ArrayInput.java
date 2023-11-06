package _2_Implementation.ArraysAndArrayList;
import java.util.Arrays;  // required for toString method.
import java.util.Scanner;
public class ArrayInput {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int[] arr = new int[5];
        // input using for-loop:
        for (int i = 0; i < arr.length; i++) {  // length is an integer variable which represents array length in Array Class
            System.out.print("arr["+(i+1)+"] = ");
            arr[i] = s1.nextInt();
        }
        System.out.println();
        // printing in same way:
        System.out.println("Printing with standard for loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" arr["+(i+1)+"] = "+arr[i]);
        }
        System.out.println();
        // printing using enhanced for loop: (bit closer to Python)
        System.out.println("Printing using enhanced for loop:");
        for (int element : arr){  // Simply printing the elements: for every element in array, print the element.
            System.out.print(" "+element);
        }

        System.out.println();
        // Another easier way to print: (Best)
        System.out.println("Printing using toString() method of Arrays Class: ");
        System.out.println(Arrays.toString(arr)); // converts array to a String and prints the String.
    }
}
