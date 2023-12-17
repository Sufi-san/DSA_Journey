package _2_Implementation.Recursion.PatternsNSortQues;

import java.util.Arrays;

public class Q3_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 0, 1, 8, 4};
        recursiveBubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void recursiveBubbleSort(int[] arr) {
        helper(arr, 0, 0);
    }

    static void helper(int[] arr, int index, int sortedCount) {
        if(sortedCount == arr.length - 1) return;
        if(index == arr.length - 1) {
            helper(arr, 0, sortedCount + 1);
            return;
        }
        if(arr[index] > arr[index + 1]) swap(arr, index, index + 1);
        helper(arr, index + 1, sortedCount);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
