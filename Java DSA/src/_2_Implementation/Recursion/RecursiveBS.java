package _2_Implementation.Recursion;

import java.util.Arrays;

public class RecursiveBS {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 44, 59, 66, 87, 88, 99};
        System.out.println("Given Array: "+Arrays.toString(arr));
        int index1 = recursiveBS(arr, 0, arr.length - 1, 59);
        System.out.println("Element is at index: "+index1);
    }

    // My Approach:
    static int recursiveBS(int[] arr, int start, int end, int target){
        int mid = start + (end - start) / 2;
        if(start <= end){
            if(target > arr[mid]) return recursiveBS(arr, mid + 1, end, target);
            else if(target < arr[mid]) return recursiveBS(arr, start, mid - 1, target);
            else return mid;
        }
        return -1;
    }

    // Kunal Approach: same as mine
}
