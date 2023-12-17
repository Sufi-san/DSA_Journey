package _2_Implementation.Recursion.PatternsNSortQues;

import java.util.Arrays;

public class Q4_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        recursiveSelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void recursiveSelectionSort(int[] arr) {
        helper(arr, 0, 0, arr.length - 1);
    }

    static void helper(int[] arr, int index, int maxIndex, int endIndex) {
        if(endIndex == 0) return;
        if(index <= endIndex) {
            if(arr[maxIndex] < arr[index]) maxIndex = index;
            helper(arr, index + 1, maxIndex, endIndex);
            return;
        }
        swap(arr, endIndex, maxIndex);
        helper(arr, 0, 0, endIndex - 1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
