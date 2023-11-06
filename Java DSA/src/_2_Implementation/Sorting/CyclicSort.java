package _2_Implementation.Sorting;

import java.util.Arrays;

public class CyclicSort { // Important pattern for amazon, google, fb companies
    // Sorting an array using only 1 pass, N comparisons
    // When given range from 1 to N, use CYCLIC SORT  (IMPORTANT LINE)
    // Value at every index becomes Index + 1, as all elements are contiguous and have a difference of 1
    // OR Every value gets assigned to Index where Index = Value - 1
    // The above logic can be applied for varied continuous ranges too, e.g: 0 to N, 1 to N - 1, 3 to N - 2 etc.

    /*
        Time Complexity:
        Best Case: O(N) (array already sorted, iterate through the array once)
        Worst Case: O(N - 1 + N) = O(2N - 1) = O(N) (When all swaps are required at first index)
     */
    public static void main(String[] args) {
        int[] arr = {8, 7, 1, 9, 5, 2, 6, 3, 4}, arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        System.out.println("Given Array: "+Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println("After Cyclic Sort: "+Arrays.toString(arr));
        System.out.println("Given Array: "+Arrays.toString(arr2));
        kunalCyclicSort(arr2);
        System.out.println("After Kunal Cyclic Sort: "+Arrays.toString(arr2));
    }

    static void swap(int[] arr, int index, int correctIndex){
        int temp = arr[index];
        arr[index] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

    // My Approach: (This approach should be avoided, it simply sets correct values without considering previous ones)
    static void cyclicSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
    }

    // Kunal Approach:
    static void kunalCyclicSort(int[] arr){
        int count = 0, optCount = 0;
        int index = 0; // to check whether pointer has iterated through all array elements
        while(index < arr.length){
            count++;
            int correct = arr[index] - 1;
            if(arr[index] != arr[correct]){ // checks if element is already at correct index.
                swap(arr, index, correct);  // if not, swap to correct index.
            }
            else {
                index++; // move to next array index.
            }
            System.out.println("After iteration "+count+": "+Arrays.toString(arr));
        }
    }
}
