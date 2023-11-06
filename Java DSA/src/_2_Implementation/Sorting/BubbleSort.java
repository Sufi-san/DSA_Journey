package _2_Implementation.Sorting;

import java.util.Arrays;

public class BubbleSort { // Also known as Sinking Sort/ Exchange Sort.
    // Comparison sort method
    // In every step, compare adjacent elements and swap according to required sorting (ascending/descending)
    // First Pass (Step 1): Largest element at the end (for ascending)
    // Second Pass (Step 2): The second-largest element at second last index.
    // This behaviour is repeated till the array is sorted.
    // At every step the largest element from unsorted portion of the array comes at end.

    /*
        Time Complexity:
        Best Case: O(N) (j never swaps for any value means array is sorted)
        Worst Case: O(N^2)

        Space Complexity: O(1) ... (in-place sorting algorithm) (no new array created)
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}, arr2 = {1, 2, 3, 4, 5}, arr3 = {5, 4, 3, 2, 1}, arr4 = {5, 4, 3, 2, 1};
        System.out.println("Array1 before Bubble Sort: "+Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println();
        System.out.println("Array2 before Bubble Sort: "+Arrays.toString(arr2));
        kunalBSort(arr2);
        System.out.println();
        System.out.println("Array3 before Bubble Sort: "+Arrays.toString(arr3));
        bubbleSort(arr3);
        System.out.println();
        System.out.println("Array4 before Bubble Sort: "+Arrays.toString(arr4));
        kunalBSort(arr4);
        System.out.println("\nArray1 after Bubble Sort: "+Arrays.toString(arr1));
        System.out.println("Array2 after Bubble Sort: "+Arrays.toString(arr2));
        System.out.println("Array3 after Bubble Sort: "+Arrays.toString(arr3));
        System.out.println("Array4 after Bubble Sort: "+Arrays.toString(arr4));

    }

    static void swap(int[] arr, int j){
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    // My Approach:
    static void bubbleSort(int[] arr){
        boolean isSorted;
        for(int i = arr.length - 1; i >= 0; i--){
            isSorted = true;
            for(int j = 0; j < i; j++){ // 'j < i' makes sure that loop does not run for second (sorted) part of the array
                if(arr[j] > arr[j + 1]){
                    swap(arr, j);
                    isSorted = false; // identifying the array as unsorted
                }
            }
            if(isSorted) break; // if this condition is not added loop will run again even when array is already sorted.
            // Note: One extra pass will always be required for even sorted arrays (best case O(N)) to check whether they are sorted.
            System.out.println("Array after Pass "+(arr.length - i)+": "+Arrays.toString(arr));
        }
    }

    // Kunal Approach: Just a change in the for-loop styles and array indices.
    static void kunalBSort(int[] arr){
        boolean swapped;
        for(int i = 0; i < arr.length; i++){
            swapped = false;
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
            System.out.println("Array after Pass "+(i + 1)+": "+Arrays.toString(arr));
        }
    }
}
