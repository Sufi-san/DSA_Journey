package _2_Implementation.Searching.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class InfinityBS {
    // Performing Binary Search on an infinite array
    // using non-decreasing (ascending sort) array
    /*
        What we can do is that, instead of using .length to find the end of the array
        and follow a top-down approach (division of size until element found), what we
        will do is start small, make the 'start' pointer point to first element, 'end'
        point to element next to start and increase the search section size exponentially
        till element is found, a bottom-up approach (exponentiation until element found).

        Time Complexity will however, still be O(logN) as we are using the same approach
        in a different order.
        E.g: 8 -> 4 -> 2 -> 1 (top-down), 1 -> 2 -> 4 -> 8 (bottom-up)
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[]{1, 12, 25, 26, 27, 38, 39, 40, 41, 42, 43, 44, 45, 46, 50};
        // Suppose it is an infinite array, can be increased indefinitely
        // ArrayLists can also be used, but a few more arrangements will have to be made accordingly
        // Like creating a loop for user to add/remove elements to list (as it is infinite), till user presses 'X' to end loop
        System.out.println("Array: "+ Arrays.toString(arr));
        System.out.println("Enter element to find its index:");
        int target = in.nextInt();
        int index1 = ans(arr, target);
        int index2 = infBinarySearch(arr, target);
        System.out.println("Index using Kunal's Approach: "+index1+"\nUsing modified approach: "+index2);
    }

    // Kunal's Approach:
    static int ans(int[] arr, int target){
        int start = 0, newStart;
        int end = 1;
        try {
            while (target > arr[end]) {
                newStart = end + 1;
                end += (end - start + 1) * 2;
                start = newStart;
            }
        }
        catch(Exception e){
            System.out.println("Range exceeded by end pointer. (1)");
        }
        return infBinarySearch(arr, target, start, end);
    }

    static int infBinarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            try {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
            catch (Exception e){  // This executes if mid is out of bound for array
                end = mid - 1;
            }
        }
        return -1;
    }

    /* Difference between approaches:
        What I overlooked the first time was that if there is no possibility of the target appearing in a given
        range, I can just simply not apply binary search on that range and only check the one which has a
        possibility of containing target.

        Condition: If arr[end] > target (target must be present in selected range)

        Kunal used another function to find the range, what I can do is find whether condition holds true in
        the binary search loop itself by using an if condition at the start.
        Hence, the only difference between the new approach and kunal's approach would be the use of single/multiple
        while loops.

        But, there is another unnecessary element present in my new approach, it has to check for the condition multiple
        times to ensure that target is inside the range and following code snippet should not execute again.
     */

    // My new approach:
    static int infBinarySearch(int[] arr, int target){
        int start = 0;
        int end = 1;
        int temp = end;
        while(start <= end){
            try {
                if (arr[temp] < target) { // temp makes sure the range upper limit never changes
                    end += (end - start + 1) * 2;
                    start = temp + 1; // temp is also used to update start using old end value
                    temp = end; // storing new end value in temp
                    continue; // makes sure that rest of the loop commands does not execute for incorrect range
                }
            }
            // If in case end pointer exceeds even once, the catch condition will run every time the loop runs after that
            catch(Exception e){
                System.out.println("Range exceeded by end pointer. (2)");
            }
            int mid = start + (end - start) / 2;
            try {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
            catch (Exception e){ // This will keep running till we do not get a valid mid which is less than array size
                end = mid - 1;
            }
        }
        return -1;  // element had possibility of appearing in given range, but it isn't there.
    }

}
