package _2_Implementation.Sorting;

import java.util.Arrays;

public class StableUnstableSort {
    /*
     For a given sequence, if original order is maintained for identical values,
     Then the sorting is STABLE
     If not, then the sorting is UNSTABLE

     Example: 10(black), 20(red), 30(black), 40(black), 30(red), 20(black), 10(red)
     Sorting by -
     1. Bubble Sort: 10(black), 10(red), 20(red), 20(black), 30(black), 30(red), 40(black)

     Conclusion:
     1. Bubble Sort - The original color wise order is preserved, thus the sorting is STABLE
     */
    public static void main(String[] args) {
        // Demonstrating Stable/Unstable by using integer sorting for double datatype array.
        double[] arr = {10.9, 20.1, 30.9, 40, 30.1, 20.9, 10.1};
        System.out.println("\nArray before Bubble Sort: "+Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Array after Bubble Sort: "+Arrays.toString(arr));
        System.out.println("Thus, Bubble Sort is STABLE.");
    }

    static void swap(double[] arr, int j){
        double temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    static void bubbleSort(double[] arr){
        boolean isSorted;
        for(int i = arr.length - 1; i >= 0; i--){
            isSorted = true;
            for(int j = 0; j < i; j++){
                if((int) arr[j] > (int) arr[j + 1]){ // Typecasting both double to integers for checking stability.
                    swap(arr, j);
                    isSorted = false;
                }
            }
            if(isSorted) break;
        }
    }
}
