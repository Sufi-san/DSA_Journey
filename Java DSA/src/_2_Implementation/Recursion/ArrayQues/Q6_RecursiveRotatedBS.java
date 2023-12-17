package _2_Implementation.Recursion.ArrayQues;

import java.util.Arrays;

public class Q6_RecursiveRotatedBS {
    /*
        In a rotated sorted array, the originally sorted array is rotated at a given index and elements
        equal to the number of rotations, are placed at the opposite end of the array.
        Eg:
            Sorted Array = {1, 2, 3, 5, 6, 7, 8, 9}
            1 Left Rotation on Sorted Array = {2, 3, 5, 6, 7, 8, 9, 1}
            4 Right Rotations on Sorted Array = {6, 7, 8, 9, 1, 2, 3, 5}
            3 Left Rotations on Sorted Array = {5, 6, 7, 8, 9, 1, 2, 3}

        In iterative method, we had to find the 'pivot' element from which array started rotation and,
        use it to divide the array into two ascending arrays.
        Binary Search is then separately applied on both arrays.
        The above method can also be applied by finding the 'minimum' element's index instead of pivot
     */
    public static void main(String[] args) {
        int[][] arrOfArr = {{5, 6, 7, 8, 9, 1, 2, 3}, {1}, {1, 3}, {3, 1}, {1, 2, 3}, {8, 9, 2, 3, 4}, {1, 3}, {5, 1, 3}};
        int[] targets = {2, 0, 0, 1, 1, 9, 3, 3};
        for(int i = 0; i < arrOfArr.length; i++) {
            System.out.println("Array: "+Arrays.toString(arrOfArr[i])+", Target: "+targets[i]);
            System.out.println(iterativeBS(arrOfArr[i], targets[i]));
            System.out.println(recursiveBS(0, arrOfArr[i].length - 1, arrOfArr[i], targets[i]));
            System.out.println(kunalRecursiveBS(0, arrOfArr[i].length - 1, arrOfArr[i], targets[i]));
        }
    }

    static int iterativeBS(int[] arr, int target) {
        int start = 0, end = arr.length - 1, pivot = -1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(mid > 0 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                pivot = mid;
                break;
            }
            else if(mid == 0 && arr[mid] > arr[mid + 1]) end = mid;
            else if(arr[mid] > arr[arr.length - 1]) start = mid + 1;
            else end = mid - 1;
        }
        if(pivot == -1) pivot = end;
        int targetIndex = simpleBS(arr, 0, pivot, target);
        if(targetIndex == -1) targetIndex = simpleBS(arr, pivot + 1, arr.length - 1, target);
        return targetIndex;
    }

    static int simpleBS(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    // My Recursive Approach:
    static int recursiveBS(int start, int end, int[] arr, int target) {
        if(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            if(arr[start] < arr[end]) { // Normal Sorted Array without rotation
                if(arr[mid] > target) return recursiveBS(start, mid - 1, arr, target);
                else if(arr[mid] < target) return recursiveBS(mid + 1, end, arr, target);
            }
            if(arr[mid] > arr[end]) { // Rotated Array where mid is on the left part
                if(target < arr[mid] && target > arr[end]) return recursiveBS(start, mid - 1, arr, target);
                else return recursiveBS(mid + 1, end, arr, target);
            }
            else { // Rotated Array where mid is on the right part
                if(target > arr[mid] && target <= arr[end]) return recursiveBS(mid + 1, end, arr, target);
                else return recursiveBS(start, mid - 1, arr, target);
            }
        }
        return -1;
    }

    // Kunal's Recursive Approach: (Adjusting the start and end before finally making a recursive call)
    static int kunalRecursiveBS(int start, int end, int[] arr, int target) {
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == target) return mid;
        if(arr[start] <= arr[mid]) { // Check if first half is sorted and if it contains target
            if(target >= arr[start] && target < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        // 'Else-if' will execute only if first half wasn't sorted, but we want to check any 'sorted' portion FIRST
        // check if second half contains the target
        // How do we know if 'arr[mid + 1] <= arr[end]' i.e. second half is sorted ??
        // Because in a Rotated sorted Array at ANY Point if a particular half is not sorted, the other half is
        // GUARANTEED to be sorted. (Try some examples if required)
        else if(target >= arr[mid + 1] && target <= arr[end]) start = mid + 1;
        // 'Else' will execute only if the 'target' is NOT present in the sorted portion
        // This means the target is definitely in an unsorted part
        // However, below we are checking only unsorted part of 'first-half'. Why ??
        // Because the case of 'target' being in unsorted 'second-half' is handled ALREADY in case for sorted first-half
        else end = mid - 1;
        // below we make a recursive call using the updated 'start' and 'end'
        return kunalRecursiveBS(start, end, arr, target);
    }
}
