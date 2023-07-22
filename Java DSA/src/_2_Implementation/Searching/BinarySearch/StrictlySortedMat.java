package _2_Implementation.Searching.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class StrictlySortedMat {
    // Q. Matrix is sorted in a row wise & column wise manner.
    /* e.g: [11, 12, 13, 14]
            [15, 16, 17, 18]
            [19, 20, 21, 22]
            [23, 24, 25, 26]
     */
    /* More improvements can be made to both the approaches like
        Making it work for any type of 2D array and not just matrices, (empty rows/columns etc.).
        Covering up all erroneous edge cases.
        Comparing target to last column's elements instead of finding floor in first column.
        Removing the excess amount of if-else statements from Kunal's Approach. (I purposely used
        them to do exactly what Kunal told).
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] mat = {{11, 12, 13, 14},
                {15, 16, 17, 18},
                {19, 20, 21, 22},
                {23, 24, 25, 26}};
        System.out.println("Given Matrix: ");
        for(int[] row: mat){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Enter target element: ");
        int target = in.nextInt();
        int[] index1 = binarySearch2D(mat, target);
        int[] index2 = binarySearch2D_2(mat, target);
        System.out.println("Element is at index: "+Arrays.toString(index1)+"\nKunal's Approach: "+Arrays.toString(index2));
    }

    // Easy Approach:
    static int[] binarySearch2D(int[][] mat, int target){
        if(mat.length == 0) return new int[]{-1, -1}; // edge case

        int start = 0, end = mat.length - 1, mid;
        while(start <= end){ // finding the largest value smaller than target in first column
            mid = start + (end - start) / 2;
            if(mat[mid].length == 0) return new int[]{-1, -1};
            if(mat[mid][0] < target){
                start = mid + 1;
            }
            else if(mat[mid][0] > target){
                end = mid - 1;
            }
            else{
                return new int[]{mid, 0};
            }
        }
        // resetting bounds
        start = 0;
        int temp = end;
        end = mat[temp].length - 1;
        while(start <= end){ // finding the target in the row in which largest element smaller than target exists
            mid = start + (end - start) / 2;
            if(mat[temp][mid] < target){
                start = mid + 1;
            }
            else if(mat[temp][mid] > target){
                end = mid - 1;
            }
            else{
                return new int[]{temp, mid};
            }
        }
        return new int[]{-1, -1};
    }

    // Kunal's Approach: (A bit difficult to understand this time)
    static int[] binarySearch2D_2(int[][] mat, int target){
        // Edge cases:
        if(mat.length == 0) return new int[]{-1, -1};
        if(mat.length == 1) return binarySearch(mat, 0, mat[0].length - 1, 0, target);

        int rowStart = 0, rowEnd = mat.length - 1, mid, mid_col = rowStart + (rowEnd - rowStart) / 2;
        int[] ans_arr, notFoundArr = new int[]{-1, -1};

        while(rowStart + 1 < rowEnd){ // checking values in only one column which is in the middle of the matrix
            mid = rowStart + (rowEnd - rowStart) / 2;
            if(mat[mid].length == 0) return notFoundArr;
            if(mat[mid][mid_col] < target){ // means upper rows are eliminated from search
                rowStart = mid;
            }
            else if(mat[mid][mid_col] > target){ // means lower rows are eliminated from search
                rowEnd = mid;
            }
            else{
                return new int[]{mid, mid_col}; // if element is found in selected column
            }
        }
        /*
         Even if the element is not found at this point, the search space is reduced to 2 rows on which we have our
         rowStart and rowEnd pointers and on which binary search can be applied one after another.
         Kunal mentioned using BinarySearch separately first on the two elements of selected column, then on then
         taking the selected column as the partition, binary search on first portion of the row pointed at by
         rowStart, then on the second portion of it and then on the first and second portion of the row pointed at
         by rowEnd.

         This leaves me wondering as for why can we not apply binary search directly on the rowStart & rowEnd rows?
         */
        // More Edge cases:
        if(mat[rowStart].length == 0) return notFoundArr;
        if(mat[rowEnd].length == 0) return notFoundArr;

        if(mat[rowStart][mid_col] == target){
            return new int[]{rowStart, mid_col};
        }
        else if(mat[rowEnd][mid_col] == target){
            return new int[]{rowEnd, mid_col};
        }
        ans_arr = binarySearch(mat, 0, mid_col - 1, rowStart, target);
        if (Arrays.equals(ans_arr, notFoundArr)) ans_arr = binarySearch(mat, mid_col + 1, mat.length - 1, rowStart, target);
        if (Arrays.equals(ans_arr, notFoundArr)) ans_arr = binarySearch(mat, 0, mid_col - 1, rowEnd, target);
        if (Arrays.equals(ans_arr, notFoundArr)) ans_arr = binarySearch(mat, mid_col + 1, mat.length - 1, rowEnd, target);
        return ans_arr;
    }

    static int[] binarySearch(int[][] mat, int start, int end, int row, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mat[row][mid] > target){
                end = mid - 1;
            }
            else if(mat[row][mid] < target){
                start = mid + 1;
            }
            else{
                return new int[]{row, mid};
            }
        }
        return new int[]{-1, -1};
    }
}
