package _2_Implementation.Searching.BinarySearch;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    // Works for Sorted Arrays
    // Best case: O(1)
    // Worst case: O(logN)
    /* Suppose 'N' is the size of an array,
        First Comparison: N/2, Second Comparison: N/(2^2): ... kth Comparison: N/(2^k)
        Thus, at last we know only 1 element is left in array:
        1 = N/(2^k),
        2^k = N,
        k * log2 = logN,
        k = logN/log2 = log(base 2)N
        Thus, the worst case of comparison needs logN comparisons.
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr1 = new int[]{24, -1, 8, 94, 88, 0, -4};
        int[] arr2 = new int[]{94, 88, 24, 8, 0, -1, -4};
        Arrays.sort(arr1);
        System.out.println("Array after sorting: "+Arrays.toString(arr1)+"\nIn Descending Form: "+Arrays.toString(arr2));
        int element = in.nextInt();
        int index = binarySearch(0, arr1.length - 1, arr1, element); //  comparisons
        int index2 = binarySearch2(arr1, element);
        int index3 = binarySearch3(arr2, element);
        System.out.println("Index of '"+element+"' in arr1: "+index+"\nIndex by second function: "+index2+"\nIndex in descending arr1: "+index3);
    }

    // My try at implementing: No Loop but I guess, more load on stack due to 4 parameters and recursion (Recursive Approach)
    static int binarySearch(int start, int end, int[] arr, int target){

        if (start > end) return -1;
        int mid = (start + end)/2; // the (start + end) approach has a chance of being incorrect due to exceeding 'int' limit
        if (arr[mid] == target) return mid;
        if (arr[mid] > target) return binarySearch(start, mid - 1, arr, target);
        if (arr[mid] < target) return binarySearch(mid + 1, end, arr, target);
        return -1;
    }


    // According to Kunal's Instructions: One While loop present (Iterative Approach)
    static int binarySearch2(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            // int mid = (start + end)/2; the (start + end) approach has a chance of being incorrect due to exceeding 'int' limit
            // Better way is:
            int mid = start + (end - start) / 2; // (end - start)/2 gets executed first and then added to start
        /* Reasoning: Basic Mathematics & Operator Priority
            Let start = s, end = e
            Thus mid = s + {(e - s)/2} = (2s + e - s)/2 = (s + e)/2  (this means that both expression return same value)
            However, due to operator priority, division occurs after the subtraction in brackets,
            eliminating the chance of range exceeding.
         */

            if(arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    static int binarySearch3(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            // Conditions are now reversed for descending/decreasing array
            if(arr[mid] < target) end = mid - 1;
            else if(arr[mid] > target) start = mid + 1;
            else return mid;
        }
        return -1;
    }
}
