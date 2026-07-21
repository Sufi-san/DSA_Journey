package _2_Implementation.ArraysAndArrayList;

import java.util.Arrays;

public class InsideFunctions {
    public static void main(String[] args) {
        int[] nums ={25,35,65,85};
        System.out.println(Arrays.toString(nums));
        modify(nums);  // passed by value OF reference as Arrays are non-primitive
        System.out.println(Arrays.toString(nums));
        // Thus, arrays are mutable in Java.
    }
    static void modify(int[] arr){  //  as main function is static, the function to be called must also be static
        arr[0] = 23;  // changing array elements
        arr[3] = 34;
    }
}
