package _2_Implementation.Sorting;

import java.util.Arrays;

public class InsertionSort {
    // Insertion Sort
    // Idea: Sort till index no. 1, 2, 3, ... , n.
    // Consider the array to have an LHS(sorted) part and an RHS(unsorted) part
    // For every index that you are at in RHS, put that index's element at correct index in LHS
    // This, will be done by comparing it with elements of the sorted array
    // Thus, the element from RHS is being 'inserted' into the sorted LHS
    // At every pass LHS is further getting sorted

    /*
        Time Complexity:
        Best Case:
         O(N^2) (without optimisation)(i.e. without adding break statement in case of false condition)
         O(N) (with optimisation)(All elements are in ascending/descending order as per requirement)
        Worst Case: O(N^2)

        Space Complexity: O(1) ... (in-place sorting algorithm) (no new array created)
     */

    /*
        Why use Insertion Sort?
        It is adaptive, steps get reduced if array is sorted.
        No. of swaps reduced, as compared to bubble sort.
        It is stable.
        Mostly used for smaller sizes and works good when array is partially sorted.
        Thus, they are also used in hybrid sorting algorithms.
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}, arr2 = {1, 2, 3, 4, 5}, arr3 = {5, 4, 3, 2, 1}, arr4 = {5, 4, 3, 2, 1};
        System.out.println("Array1 before Insertion Sort: "+ Arrays.toString(arr1));
        insertionSort(arr1);
        System.out.println();
        System.out.println("Array2 before Insertion Sort: "+Arrays.toString(arr2));
        kunalInsSort(arr2);
        System.out.println();
        System.out.println("Array3 before Insertion Sort: "+Arrays.toString(arr3));
        insertionSort(arr3);
        System.out.println();
        System.out.println("Array4 before Insertion Sort: "+Arrays.toString(arr4));
        kunalInsSort(arr4);
        System.out.println("\nArray1 after Insertion Sort: "+Arrays.toString(arr1));
        System.out.println("Array2 after Insertion Sort: "+Arrays.toString(arr2));
        System.out.println("Array3 after Insertion Sort: "+Arrays.toString(arr3));
        System.out.println("Array4 after Insertion Sort: "+Arrays.toString(arr4));
    }

    static void swap(int[]arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // My Approach
    static void insertionSort(int[] arr){ // Ascending Insertion Sort
        for(int i = 0; i < arr.length - 1; i++){
            int compareIndex = i + 1; // This is not required, Kunal's approach is better
            for(int j = i; j >= 0; j--){ // Compares all required indices' element in LHS with selected element
                if(arr[compareIndex] < arr[j]){ // Swap occurs everytime a greater element is found
                    swap(arr, compareIndex, j);
                    compareIndex = j;
                }
                else{  // If the case holds false, then no need to check further as LHS is already sorted.
                    break;
                }
            }
            System.out.println("Current Array (After Pass "+(i+1)+"): "+Arrays.toString(arr));
        }
    }

    // Kunal Approach: does not use an extra variable
    static void kunalInsSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j > 0; j--){ // Starting with 'i + 1' eliminates the need for another variable
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                }
                else{
                    break;
                }
            }
            System.out.println("Current Array (After Pass "+(i+1)+"): "+Arrays.toString(arr));
        }
    }
}
