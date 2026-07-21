package _2_Implementation.Recursion.PatternsNSortQues;

import java.util.Arrays;

public class Q_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println("Array before Insertion Sort: "+Arrays.toString(arr));
        recursiveInsertionSort(arr);
        System.out.println("Array after Insertion Sort: "+Arrays.toString(arr));
    }

    static void recursiveInsertionSort(int[] arr) {
        helper(arr, 1, 2);
    }

    static void helper(int[] arr, int index, int nextIndex) {
        if(index == arr.length) return;
        if(index == 0) {
            System.out.println(Arrays.toString(arr));
            helper(arr, nextIndex, nextIndex + 1);
            return;
        }
        if(arr[index] < arr[index - 1]) {
            swap(arr, index, index - 1);
            helper(arr, index - 1, nextIndex); // Will check previous indices only if the swap case holds true
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
