package _2_Implementation.Searching.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class RotationCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int x = in.nextInt();
        int[] arr = new int[x];
        for(int i = 0; i < x; i++){
            System.out.println("arr["+i+"] = ");
            arr[i] = in.nextInt();
        }
        System.out.println("Given Array: "+Arrays.toString(arr));
        int ans1 = findRotationCount(arr);
        int ans2 = kunalRotationCount(arr);
        System.out.println("Rotation according to ascending sort: "+"\nMy Approach: "+ans1+"\nKunal Approach: "+ans2);
    }

    // My Approach: (finding index of minimum (original start) element)
    static int findRotationCount(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[end]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return end;
    }

    // Kunal Approach: (finding index of pivot/max (original end) element and then adding 1 to it)
    // This approach was used by Kunal for another problem, but I used it here just for the sake of remembering.
    static int kunalRotationCount(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            // Case1: First possibility of finding pivot as mid.
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid + 1; // Here, mid is original end element's current index (peak index).
                // So, return peak index + 1 to get number of rotations
            }
            // Case2: Finding element after pivot as mid. (the only descending point in array)
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid; // Here, mid is original start element's current index. (index of element after peak)
                // So, return min index to get number of rotations
            }
            // Case3: Checking if 'mid' lies in first half and setting 'start' pointer accordingly
            if(arr[mid] > arr[start]){
                start = mid + 1; // +1 because it cannot be peak element (cannot be original end)
            }
            // Case4: If 'mid' lies in second half and setting 'end' pointer accordingly
            else{ // arr[mid] < arr[start]
                end = mid - 1; // -1 because it cannot be peak or element after peak (cannot be original start)
            }
        }
        // In kunal's approach this was: 'return -1', as he needed a pivot element and if it wasn't present he returned -1
        // However, here I require the index of minimum element (number of rotations)
        // And the absence of pivot suggests that the array was not rotated at all, thus index of first element is 0
        return 0;
    }
}
