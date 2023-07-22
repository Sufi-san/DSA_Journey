package _2_Implementation.Searching.BinarySearch;
import java.util.Arrays;
import java.util.Scanner;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Basically when we do not know the order in which the array is sorted, we check the first and last element
        int[] arr = new int[8];
        System.out.println("Enter elements for an ascending or descending sorted array:");
        for(int i = 0; i < arr.length; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(arr)+" Array with unknown sort entered.");
        System.out.println("Enter element to search for: ");
        int target = in.nextInt(), ans;
        ans = orderAgnosticBS(arr, target);
        System.out.println("Element is at index: "+ans);
    }

    static int orderAgnosticBS(int[]arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isDesc = arr[start] > arr[end];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < target){
                if(isDesc) end = mid - 1;
                else start = mid + 1;
            }
            else if(arr[mid] > target){
                if(isDesc) start = mid + 1;
                else end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
