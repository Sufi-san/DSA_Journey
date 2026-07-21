package _2_Implementation.Recursion.ArrayQues;

public class Q1_SortedArray {

    // Check whether given array is sorted using Recursion
    public static void main(String[] args) {
        int[] arr = {23, 44, 15, 92, 105};
        System.out.println(isSorted(arr));
    }

    static boolean isSorted(int[] arr) {
        return helper(0, arr);
    }

    static boolean helper(int index, int[] arr) {
        if(index == arr.length - 1) return true;
        return (arr[index] < arr[index + 1]) && helper(index + 1, arr);
    }
}
