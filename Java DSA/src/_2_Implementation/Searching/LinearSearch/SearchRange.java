package _2_Implementation.Searching.LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchRange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr1 = new int[]{24, -1, 8, 94, 88, 0, -4};
        System.out.println("Given Array: "+ Arrays.toString(arr1));
        System.out.println("Enter lower bound (starting index): ");
        int lb = in.nextInt();
        System.out.println("Enter upper bound (ending index): ");
        int ub = in.nextInt();
        if(lb < 0 || lb > arr1.length - 1) {
            System.out.println("lower bound out of range setting it to zero");
            lb = 0;
            System.out.println("lb = "+lb);
        }
        if(ub > arr1.length - 1 || ub < 0){
            System.out.println("upper bound out of range setting it to arr.length - 1");
            ub = arr1.length - 1;
            System.out.println("ub = "+ub);
        }
        System.out.println("Enter target element: ");
        int target = in.nextInt();
        int index = linearSearch(arr1, lb, ub, target); // Providing upper and lower bound of range to search in
        System.out.println("Index of element in:\narr1: "+index);
    }

    static int linearSearch(int[] arr,int lb, int ub, int target){
        if(arr.length == 0) return -1;
        for(int i = lb; i <= ub; i++){
            if(arr[i] == target) return i;// Returns index of found element
        }
        return -1; // If element not found
    }
}
