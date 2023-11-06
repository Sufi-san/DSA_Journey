package _2_Implementation.Sorting;

import java.util.Arrays;

public class SelectionSort {
    // Selection (selecting element from interval) sort method
    // In every step, find min/max element's index and swap according to required sorting (ascending/descending)
    // First Pass (Step 1): Largest element at the end if max is selected (Smallest at start if min is selected).
    // Second Pass (Step 2): The second-largest element at second last index for max.
    // This behaviour is repeated till the array is sorted.
    // At every step the largest/smallest element from unsorted portion of the array comes at end/start.

    /*
        Time Complexity:
        Best Case:
         O(N^2) (without optimisation)
         O(N) (with optimisation)(All elements are in ascending/descending order as per requirement) (questionable)
        Worst Case: O(N^2) (Last element of the array needs to be placed at second last position or first at second position)

        Space Complexity: O(1) ... (in-place sorting algorithm) (no new array created)

        Selection Sort is great when size of array is small.
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}, arr2 = {1, 2, 3, 4, 5}, arr3 = {1, 2, 3, 5, 4}, arr4 = {2, 1, 3, 4, 5};
        System.out.println("Array1 before Selection Sort: "+ Arrays.toString(arr1));
        selectionSort(arr1);
        System.out.println();
        System.out.println("Array2 before Selection Sort: "+Arrays.toString(arr2));
        kunalSelSort(arr2);
        System.out.println();
        System.out.println("Array3 before Selection Sort: "+Arrays.toString(arr3));
        selectionSort(arr3);
        System.out.println();
        System.out.println("Array4 before Selection Sort: "+Arrays.toString(arr4));
        kunalSelSort(arr4);
        System.out.println("\nArray1 after Selection Sort: "+Arrays.toString(arr1));
        System.out.println("Array2 after Selection Sort: "+Arrays.toString(arr2));
        System.out.println("Array3 after Selection Sort: "+Arrays.toString(arr3));
        System.out.println("Array4 after Selection Sort: "+Arrays.toString(arr4));
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // My Approach:
    static void selectionSort(int[] arr){ // Ascending Selection Sort
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i; // setting minimum element's index as the current start of interval in array
            boolean isSorted = true; // assuming the array is now sorted
            for(int j = i; j < arr.length; j++){ // j = i, makes sure that sorted portion is left untouched
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
                if(j < arr.length - 1 && arr[j] > arr[j + 1]){ // if any element does not follow ascending order
                    isSorted = false; // array is not sorted
                }
            }
            swap(arr, i, minIndex); // Swap minimum element with the starting element of the array interval
            System.out.println("Current Array: (After Pass "+(i+1)+")"+Arrays.toString(arr));
            if(isSorted) break; // if array is sorted, do not run the loop further
        }
         /*
         Maybe there is some downside to the optimisation as from most resources I came to know
         that the Best & Average Case time complexity of Selection Sort is also O(N^2).
         Thus, before fully understanding time complexities I will also consider it O(N^2)
         and use it without the above optimisation.
          */
    }

    // Kunal Approach: (just selecting maximum elements instead of minimum)
    static void kunalSelSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            // i < arr.length - 1 indicates loop will run n - 1 times
            // similar to how we say loop ran n times when i < arr.length due to 0-index
            int maxIndex = 0;
            for(int j = 0; j < arr.length - i; j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            swap(arr,arr.length - 1 - i, maxIndex);
            System.out.println("Current Array: (After Pass "+(i+1)+")"+Arrays.toString(arr));
        }
    }
}
