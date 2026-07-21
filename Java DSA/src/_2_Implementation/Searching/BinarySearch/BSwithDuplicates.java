package _2_Implementation.Searching.BinarySearch;
// Program to understand implementation of Binary Search to find lowest or highest index of target,
// in a sorted array which has duplicate values.
// It is just another approach, the other approach can be observed in "Leetcode Problems: Q.2"
import java.util.*;

public class BSwithDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {3, 3, 3, 3, 8, 7, 7, 9, 9, 9, 10, 10, 11, 12, 13, 13, 13, 14, 14};
        System.out.println("Given Array: "+Arrays.toString(arr));
        System.out.println("Choose Target Element: ");
        int target = in.nextInt();
        int index1 = simpleBS(arr, target); // find any index
        int index2 = lowDupliBS(arr, target); // find first index
        int index3 = highDupliBS(arr, target); // find last index
        System.out.printf("Index found by:\nsimpleBS: %d\nlowDupliBS: %d\nhighDupliBS: %d\n", index1, index2, index3);
    }

    static int simpleBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{ // arr[mid] < target
                start = mid + 1;
            }
        }
        return -1;
    }

    static int lowDupliBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        if(end < 0) return -1;
        System.out.println("(L, initial) Start: "+start+" End: "+end);
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] >= target){ // Searching in Initial Part of Array even if equal values
                end = mid - 1;
                System.out.println("(L, end = mid) Start: "+start+" Mid: "+mid+" End: "+end);
            }
            else{
                start = mid + 1;
                System.out.println("(L, start = mid + 1) Start: "+start+" Mid: "+mid+" End: "+end);
            }
        }
        start = (start < arr.length && start >= 0 && arr[start] == target)? start: -1; // Ensuring 'start' is within bounds
        return start;
    }

    static int highDupliBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        if(end < 0) return -1;
        System.out.println("(H, initial) Start: "+start+" End: "+end);
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > target){
                end = mid - 1;
                System.out.println("(H, end = mid - 1) Start: "+start+" Mid: "+mid+" End: "+end);
            }
            else{ // Searching in later half of array even if equal values (arr[mid] <= target)
                start = mid + 1;
                System.out.println("(H, start = mid) Start: "+start+" Mid: "+mid+" End: "+end);
            }
        }
        end = (end < arr.length && end >= 0 && arr[end] == target)? end: -1; // Ensuring 'end' is withing bounds
        return end;
    }
}
