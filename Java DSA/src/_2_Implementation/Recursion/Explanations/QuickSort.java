package _2_Implementation.Recursion.Explanations;

import java.util.Arrays;

public class QuickSort {
    /*
        Quick Sort makes use of an important reference point called 'pivot'.
        It can be any element chosen from inside the search space or array

        Quick Sort also makes use of divide and conquer approach similar to that of Merge Sort
        However, it does not 'merge' the solutions, instead the concept of using 'pivot' is
        recursively applied in each subdivision

        Role of Pivot:
            - After each pass, the elements less than which are less than pivot element are sent
              to the left of the pivot and the one greater than pivot are sent to the right
            - MAJOR POINT: After each pass, the selected 'pivot' will be at its correct position !
            - After the pivot is sorted, the rest of the array, that is 'start' to 'pivot - 1' and
              'pivot + 1' to 'end' are sent to the next function calls to find their 'pivots' and
              sort them (Recursion takes place)
     */
    public static void main(String[] args) {
        double[] arr = {5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(double[] arr) {
        helper(arr, 0, arr.length - 1);
    }

    static void helper(double[] arr, int start, int end) {
        if(start >= end) return;
        boolean isSorted = true;
        for(int k = start; k < end; k++) {
            if(arr[k] > arr[k + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        if(isSorted) return;
        int pivot = start + (int)(end * Math.random()); // Taking a random index as pivot;
        System.out.println("Start = "+start+", End = "+end+", Pivot = "+pivot);
        int i = start, j = end;
        while(i < j) {
            while(arr[i] < arr[pivot]) i++;
            while(arr[j] > arr[pivot]) j--;
            swap(arr, i, j);
        }
        helper(arr, start, pivot - 1);
        helper(arr, pivot + 1, end);
    }

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
