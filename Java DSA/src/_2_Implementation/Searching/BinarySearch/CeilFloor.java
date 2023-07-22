package _2_Implementation.Searching.BinarySearch;
import java.util.Arrays;
import java.util.Scanner;

public class CeilFloor {
    // To find the closest ceiling or floor number inside the array for required element.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[8];
        System.out.println("Enter elements of the array in ascending or descending sort: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Given Array: "+ Arrays.toString(arr));
        System.out.println("Enter target element: ");
        int target = in.nextInt();
        System.out.println("What do you want to find?:\n1. Ceil\n2. Floor");
        int option = in.nextInt();
        boolean findCeil = (option == 1);
        int ans1 = orderAgnosticCeilFloor(arr, target, findCeil);
        int ans2 = kunalCeilFloor(arr, target, findCeil);
        String req = (findCeil)? "Ceil": "Floor";
        System.out.println(req+" for target "+target+" is: "+ans1);
        System.out.println("Kunal's method: "+req+" for target "+target+" is: "+ans2);
    }

    /* My Approach:

        To prevent the answer from getting out of range and stay between start and end pointer,
        instead of start = mid + 1 or end = mid - 1, I simply included the mid inside the next
        range using start = mid or end = mid. (Differs by ascending or descending array sort)

        Also, the while loop condition was adjusted from start <= end to start < end - 1.
        Here the loop will break when there are only two elements left inside the range
        and thus from these two we can make the floor or ceil choice as they are the ones
        closest to our target.

        Thus, arr[start] will be the floor value while arr[end] will be the ceil value.
     */
    static int orderAgnosticCeilFloor(int[] arr, int target, boolean findCeil){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        if(isAsc && (target > arr[end] || target < arr[start])) return -1;
        else if(target < arr[end] || target > arr[start]) return -1;

        while(start < end - 1){
            int mid = start + (end - start) / 2;
            if(arr[mid] > target){
                if(isAsc) end = mid; // Including the mid as we want to find floor/ceil
                else start = mid;
            }
            else if(arr[mid] < target){
                if(isAsc) start = mid;
                else end = mid;
            }
            else return arr[mid];
        }
       if(isAsc) return (findCeil)? arr[end]: arr[start];
       else return (findCeil)? arr[start]: arr[end];
    }

    /* Kunal's Approach:

        Instead of keeping the answer inside the range, Kunal uses all the same conditions from
        the true binary search algorithm and observes what happens at the end condition.

        The common sense is that the answer will lie in between the range start & end however,
        in the case of finding ceil or floor the answer will not lie in that range.
        E.g: although 14 < 15 < 16, 15 will not lie between 14 & 16 if it is not present in the array.

        Now using above example, let's say, start pointer will reach 14 first and then
        end pointer will also reach 14 after start. Let the same index be 'k'.
        The mid now will be: mid = (start + end)/2 = (k + k)/2 = k, thus same index is returned.
        Next condition that will hold true: arr[mid] < target, as 14 < 15
        Outcome 1: start = mid + 1 = k + 1, now arr[start] = arr[k + 1] = 16, arr[end] = arr[k] = 14
        Outcome 2: Since start = k + 1, end = k, as start > end the loop will now break.

        Thus, after observing the last case before loop broke, we can now say that

        1) For Ascending Sorted Array:
        Floor: (Largest value smaller than target present in the array): arr[end]
        Ceil: (Smallest value larger than target present in the array): arr[start]

        2) For Descending Sorted Array:
        Floor: (Largest value smaller than target present in the array): arr[start]
        Ceil: (Smallest value larger than target present in the array): arr[end]
     */
    static int kunalCeilFloor(int[] arr, int target, boolean findCeil){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        if(isAsc && (target > arr[end] || target < arr[start])) return -1;
        else if(target < arr[end] || target > arr[start]) return -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > target){
                if(isAsc) end = mid - 1; // Including the mid as we want to find floor/ceil
                else start = mid + 1;
            }
            else if(arr[mid] < target){
                if(isAsc) start = mid + 1;
                else end = mid - 1;
            }
            else return arr[mid];
        }
        if(isAsc) return (findCeil)? arr[start]: arr[end];
        else return (findCeil)? arr[end]: arr[start];
    }
}
