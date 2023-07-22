package _2_Implementation.Searching.LinearSearch;

import java.util.Arrays;

public class FindMaxMin {
    public static void main(String[] args) {
        int[] arr = {23, -15, 88, 77, 29, 95, 38};
        System.out.println("Given Array: "+ Arrays.toString(arr));
        int[] min_max = findMinMax(arr);
        System.out.println("Minimum Number: "+min_max[0]+"\nMaximum Number: "+min_max[1]);
    }

    static int[] findMinMax(int[] arr){
        if(arr.length == 0) return new int[]{-1, -1};
        int min = arr[0], max = arr[0];
        for(int element: arr){
            min = Math.min(min, element);
            max = Math.max(max, element);
        }
        return new int[]{min, max};
    }
}
