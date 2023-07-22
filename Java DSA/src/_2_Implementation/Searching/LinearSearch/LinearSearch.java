package _2_Implementation.Searching.LinearSearch;

import java.util.Arrays;

public class LinearSearch {
    // O(N) Time Complexity in worst case, where N is length of the structure to be searched. (linear time)
    // O(1) Time Complexity in best case, where target is found at 1st place (constant time)
    // O(N^2) Time Complexity in worst case, for 2D Array Linear Search where N is the length of the structure. (quadratic time)
    public static void main(String[] args) {
        int[] arr1 = new int[]{88, 24, -1, 89, 94, 27, 74, 33};
        int[][] arr2 = {{-1, 2, 3},{44, 55, 66}, {88, 99, 4}};
        int index = linearSearch(arr1, -1); // 3 comparisons
        int index2 = linearSearch(arr2, new int[]{88, 99, 4}); // 3 comparisons
        int[] index3 = linearSearch(arr2, 66); // 6 comparisons
        System.out.println("Index of element in:\narr1: "+index+"\nArray in arr2: "+index2);
        System.out.println("Integer in arr2: "+Arrays.toString(index3));
    }

    static int linearSearch(int[] arr, int target){
        if(arr.length == 0) return -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target) return i;// Returns index of found element
        }
        return -1; // If element not found
    }

    static int[] linearSearch(int[][]arr, int target){ // method overloading for linear search in 2D array with target integer.
        // if(arr.length == 0) return -1; this statement is no longer required as for each loop will never execute for empty arrays.
        int i = 0;
        for(int[] num: arr){
            for(int j = 0; j < num.length; j++){
                if(num[j] == target) return new int[]{i, j};
            }
            i++;
        }
        return new int[]{-1, -1};
    }

    static int linearSearch(int[][] arr, int[] targetArray){ // method overloading for linear search in 2D array with target array.
        if(arr.length == 0) return -1;
        for(int i = 0; i < arr.length; i++){
            if(Arrays.equals(arr[i], targetArray)) return i; // .deepEquals is more effective (used mostly for 2D Array Comparison)
        }
        return -1;
    }
}
