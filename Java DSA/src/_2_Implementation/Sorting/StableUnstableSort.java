package _2_Implementation.Sorting;

import java.util.Arrays;

public class StableUnstableSort {
    /*
     For a given sequence, if original order is maintained for identical values that differ by some criteria,
     Then the sorting is STABLE
     If not, then the sorting is UNSTABLE

     Example: 10(black), 20(red), 30(black), 40(black), 30(red), 20(black), 10(red)
     Sorting by -
     1. Bubble Sort: 10(black), 10(red), 20(red), 20(black), 30(black), 30(red), 40(black)
     2. Selection Sort: 10(black), 10(red), 20(black), 20(red), 30(red), 30(black), 40(black)
     3. Insertion Sort: 10(black), 10(red), 20(red), 20(black), 30(black), 30(red), 40(black)

     Conclusion:
     1. Bubble Sort - The original color wise order is preserved, thus the sorting is STABLE
     2. Selection Sort - The original color wise order is NOT preserved, thus the sorting is UNSTABLE
     3. Insertion Sort - The original color wise order is preserved, thus sorting is STABLE

     */
    public static void main(String[] args) {
        // Demonstrating Stable/Unstable by using integer sorting for double datatype array.
        double[] arr = {10.9, 20.1, 30.9, 40, 30.1, 20.9, 10.1};
        System.out.println("\nArray before Bubble Sort: "+Arrays.toString(arr));
        System.out.println("Array after Bubble Sort: "+bubbleSort(arr));
        System.out.println("Thus, Bubble Sort is STABLE.");
        System.out.println("\nArray before Selection Sort: "+Arrays.toString(arr));
        System.out.println("Array after Selection Sort: "+selectionSort(arr));
        System.out.println("Thus, Selection Sort is UNSTABLE.");
        System.out.println("\nArray before Insertion Sort: "+Arrays.toString(arr));
        System.out.println("Array after Insertion Sort: "+insertionSort(arr));
        System.out.println("Thus, Insertion Sort is STABLE.");
    }

    static void swap(double[] arr, int a, int b){
        double temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static String bubbleSort(double[] array){
        double[] arr = new double[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);
        boolean isSorted;
        for(int i = arr.length - 1; i >= 0; i--){
            isSorted = true;
            for(int j = 0; j < i; j++){
                if((int) arr[j] > (int) arr[j + 1]){ // Typecasting both double to integers for checking stability.
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if(isSorted) break;
        }
        return Arrays.toString(arr);
    }

    static String selectionSort(double[] array){
        double[] arr = new double[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);
        int minIndex;
        for(int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for(int j = i; j < arr.length; j++){
                if((int) arr[j] < (int) arr[minIndex]){ // Typecasting both double to integers for checking stability.
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return Arrays.toString(arr);
    }

    static String insertionSort(double[] array){
        double[] arr = new double[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j > 0; j--){
                if((int)arr[j] < (int)arr[j - 1]){
                    swap(arr, j , j - 1);
                }
                else{
                    break;
                }
            }
        }
        return Arrays.toString(arr);
    }
}
