package _2_Implementation.Searching.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class _2D_BinarySearch {
    // Trying Binary Search in 2 Dimensional Arrays (Matrices)
    // Q. Matrix is sorted in a row wise & column wise manner.
    /* e.g: [11, 20, 30, 40]
            [15, 25, 35, 45]
            [28, 29, 37, 49]
            [33, 34, 38, 50]
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] mat = {{11, 20, 30, 40}, {15, 25, 35, 45}, {28, 29, 37, 49}, {33, 34, 38, 50}};
        int[][] arr = {{11, 20, 30, 40}, {15}, {28, 29}, {33, 34, 38, 50}};
        System.out.println("\nGiven Matrix:");
        for(int[] row: mat){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Enter target to search for:");
        int target = in.nextInt();
        int[] index1 = binarySearch2D(mat, target);
        int[] index2 = binarySearch2D_2(mat, target);
        System.out.println("Index of element (My Approach O(N * logN)): "+Arrays.toString(index1));
        System.out.println("Index of element (Kunal Approach O(N): "+Arrays.toString(index2));
        System.out.println("Given 2D Array:");
        for(int[] row: arr){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Enter target to search for:");
        target = in.nextInt();
        int[] index3 = noFixedRowSizeSearch(arr, target);
        System.out.println("Index of element (2D Array with no fixed row size): "+Arrays.toString(index3));
    }

    // My first approach: O(N * logN), Linear Search on Matrix and Binary Search on Matrix rows.
    static int[] binarySearch2D(int[][] mat, int target){
        for(int i = 0; i < mat.length; i++){
            int start = 0;
            int end = mat[i].length - 1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(mat[i][mid] > target){
                    end = mid - 1;
                }
                else if(mat[i][mid] < target){
                    start = mid + 1;
                }
                else{
                    return new int[]{i, mid};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Kunal's Approach
    static int[] binarySearch2D_2(int[][]mat, int target){
        int row = 0;
        int col = mat.length - 1;  // will work for square matrices only
        while(row < mat.length && col >= 0){
            if(mat[row][col] > target){
                // as the column itself is in ascending sort, elements after the first one will definitely be greater
                col--; // Hence, column skipped
            }
            else if(mat[row][col] < target){
                // as the row itself is in ascending sort, elements before it will definitely be smaller.
                row++; // Hence, row skipped
            }
            else{
                return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }

    // For Irregular 2D Array: (just wanted to try it out, not very important) (Time Comp: M(rows) * N(max_column))
    // Though, worst case is still the same, the algorithm improves Time Complexity for average case taking advantage
    // of the ascending rows and ascending column values in the matrix.
    // Check Bottom for after-thought.
    static int[] noFixedRowSizeSearch(int[][] arr, int target){
        int row = 0;
        int i = 0; // For counting searches
        while(row < arr.length){
            int col = arr[row].length - 1;  // will work for any row size
            if(col - i < 0) break;
            if(arr[row][col - i] > target){ // col - i, adjusts the column index as per the number of searches made in row.
                i++; // Counting the times target not found in row.
                // As row size is not fixed, 'col - i' is a replacement for 'col--' which was used in code for squareMat search.
            }
            else if(arr[row][col - i] < target){
                // as the row itself is in ascending sort, elements before it will definitely be smaller.
                row++; // Hence, row skipped
                i = 0; // setting search count to 0 for new row.
            }
            else{
                return new int[]{row, col - i};
            }
        }
        return new int[]{-1, -1};
    }
    // It can be further improved for larger rows by using Binary Search:
    // check range for row -> get the start and end element of the row
    // -> if lesser than start at any point, then it does not exist in the matrix
    // -> if greater than end then check next row directly
    // -> if in-between start and end, apply binary search
    // Complexity becomes (M * logN) where, M is number of rows and N is max length for rows.
    // It will be same as the first approach used.
}
